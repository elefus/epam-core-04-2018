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

        if (x1 >= x2) {
            double temp = x1;
            x1 = x2;
            x2 = temp;
        }

        if (x3 >= x4) {
            double temp = x3;
            x3 = x4;
            x4 = temp;
        }

        if (x2 < x3) {
            return null;
        }

        if ((x1 - x2 == 0) && (x3 - x4 == 0)) {
            if ((Math.max(y1, y2) < Math.min(y3, y4)) || (Math.min(y1, y2) > Math.max(y3, y4))) {
                return null;
            }
        }

        double x;
        double y;

        if (x1 - x2 == 0) {
            x = x1;
            double a2 = (y3 - y4) / (x3 - x4);
            double b2 = y3 - a2 * x3;
            y = a2 * x1 + b2;

            if (!(x3 <= x && x4 >= x && Math.min(y1, y2) <= y && Math.max(y1, y2) >= y)) {
                return null;
            }

            return new Point2D(x, y);
        }

        if (x3 - x4 == 0) {
            x = x3;
            double a1 = (y1 - y2) / (x1 - x2);
            double b1 = y1 - a1 * x1;
            y = a1 * x3 + b1;

            if (x1 <= x && x2 >= x && Math.min(y3, y4) <= y && Math.max(y3, y4) >= y) {
                return null;
            }

            return new Point2D(x, y);
        }

        double k1 = (y1 - y2) / (x1 - x2);
        double k2 = (y3 - y4) / (x3 - x4);
        double b1 = y1 - k1 * x1;
        double b2 = y3 - k2 * x3;

        if (k1 == k2) {
            return null;
        }

        x = (b2 - b1) / (k1 - k2);

        if ((x < Math.max(x1, x3)) || (x > Math.min(x2, x4))) {
            return null;
        }

        y = k1 * x + b1;

        return new Point2D(x, y);
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