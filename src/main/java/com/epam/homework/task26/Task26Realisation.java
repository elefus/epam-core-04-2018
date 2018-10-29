package com.epam.homework.task26;

import java.util.*;

public class Task26Realisation implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Double, Set<I2DPoint>> intersections = new TreeMap<>();
        List<ISegment> segmentsList = new ArrayList<>(segments);
        for (int i = 0; i < segmentsList.size(); i++) {
            Set<I2DPoint> segmentIntersections = new HashSet<>();
            for (int j = i + 1; j < segmentsList.size(); j++) {
                Point2D intersectionPoint = getIntersectionPoint(segmentsList.get(i), segmentsList.get(j));
                if (intersectionPoint != null) {
                    segmentIntersections.add(intersectionPoint);
                }
            }

            addPointsX(intersections, segmentIntersections);
        }
        return intersections.firstEntry().getValue();
    }

    private void addPointsX(TreeMap<Double, Set<I2DPoint>> intersectionPoints, Set<I2DPoint> points) {
        for (I2DPoint point : points) {
            Set<I2DPoint> pointsX = intersectionPoints.containsKey(point.getX()) ? intersectionPoints.get(point.getX()) : new HashSet<>();
            pointsX.add(point);
            intersectionPoints.put(point.getX(), pointsX);
        }
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

        double a1 = -(y2 - y1);
        double b1 = x2 - x1;
        double c1 = -(a1 * x1 + b1 * y1);

        double a2 = -(y4 - y3);
        double b2 = x4 - x3;
        double c2 = -(a2 * x3 + b2 * y3);

        double firstStart = a2 * x1 + b2 * y1 + c2;
        double firstEnd = a2 * x2 + b2 * y2 + c2;

        double secondStart = a1 * x3 + b1 * y3 + c1;
        double secondEnd = a1 * x4 + b1 * y4 + c1;

        if (firstStart * firstEnd > 0 || secondStart * secondEnd > 0) {
            return null;
        }

        double d = firstStart / (firstStart - firstEnd);
        return new Point2D(x1 + d * (x2 - x1), y1 + d * (y2 - y1));
    }

    class Point2D implements I2DPoint {
        private double x;
        private double y;

        Point2D(double x, double y) {
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