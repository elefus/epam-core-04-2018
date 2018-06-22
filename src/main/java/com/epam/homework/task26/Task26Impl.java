package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Double, Set<I2DPoint>> allIntersectionPoints = new TreeMap<>();
        List<ISegment> segmentList = new ArrayList<>(segments);

        for (int i = 0; i < segmentList.size(); i++) {
            Set<I2DPoint> segmentIntersectionPoints = new HashSet<>();
            for (int j = i + 1; j < segmentList.size(); j++) {
                Point2D intersectionPoint = getIntersectionPoint(segmentList.get(i), segmentList.get(j));
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


        if ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4) == 0) {
            return null;
        }

        double a1 = y2 - y1;
        double b1 = x1 - x2;
        double c1 = -((x2 - x1) * y1 - a1 * x1);

        double a2 = y4 - y3;
        double b2 = x3 - x4;
        double c2 = -((x4 - x3) * y3 - a2 * x3);

        double d = a1 * b2 - b1 * a2;
        double d1 = c1 * b2 - b1 * c2;
        double d2 = a1 * c2 - c1 * a2;

        return new Point2D(d1 / d, d2 / d);
    }

    static class Point2D implements I2DPoint {
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