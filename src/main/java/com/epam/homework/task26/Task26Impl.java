package com.epam.homework.task26;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Double, Set<I2DPoint>> allIntersectionPoints = new TreeMap<>();

        for (ISegment segment1 : segments) {
            Set<I2DPoint> segmentIntersectionPoints = new HashSet<>();
            for (ISegment segment2 : segments) {
                if (segment1.equals(segment2)) {
                    continue;
                }

                Point2D intersectionPoint = getIntersectionPoint(segment1, segment2);
                if (intersectionPoint != null) {
                    segmentIntersectionPoints.add(intersectionPoint);
                }
            }

            allIntersectionPoints = addPointsByAbscissa(allIntersectionPoints, segmentIntersectionPoints);
        }

        return allIntersectionPoints.firstEntry().getValue();
    }

    private TreeMap<Double, Set<I2DPoint>> addPointsByAbscissa(TreeMap<Double, Set<I2DPoint>> intersectionPoints, Set<I2DPoint> points) {
        for (I2DPoint point : points) {
            if (!intersectionPoints.containsKey(point.getX())) {
                Set<I2DPoint> pointsByAbscissa = new HashSet<>();
                pointsByAbscissa.add(point);
                intersectionPoints.put(point.getX(), pointsByAbscissa);
            } else {
                intersectionPoints.get(point.getX()).add(point);
            }
        }
        return intersectionPoints;
    }

    private Point2D getIntersectionPoint(ISegment segment1, ISegment segment2) {
        double x1 = segment1.first().getX();
        double y1 = segment1.first().getY();
        double x2 = segment1.second().getX();
        double y2 = segment1.second().getY();

        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();

        double x = -((x1 * y2 - x2 * y1) * (x4 - x3) - (x3 * y4 - x4 * y3) * (x2 - x1)) / ((y1 - y2) * (x4 - x3) - (y3 - y4) * (x2 - x1));
        double y = ((y3 - y4) * x - (x3 * y4 - x4 * y3)) / (x4 - x3);

        if (!(((x1 <= x) && (x2 >= x) && (x3 <= x) && (x4 >= x)) || ((y1 <= y) && (y2 >= y) && (y3 <= y) && (y4 >= y)))) {
            return null;
        }

        if ((x2 - x1) / (y2 - y1) == (x4 - x3) / (y4 - y3)) {
            return null;
        }

        return new Point2D(x, y);
    }

    class Point2D implements I2DPoint {
        double x;
        double y;

        Point2D (double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return this.x;
        }

        @Override
        public double getY() {
            return this.y;
        }
    }
}