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
                Point2D intersectionPoint = getIntersectionPoint((Segment)  segmentList.get(i), (Segment) segmentList.get(j));
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

    private Point2D getIntersectionPoint(Segment segment1, Segment segment2) {
        if (segment1.first().getX() >= segment1.second().getX()) {
            I2DPoint temp = segment1.first();
            segment1.setFirst(segment1.second());
            segment1.setSecond(temp);
        }

        if (segment2.first().getX() >= segment2.second().getX()) {
            I2DPoint temp = segment2.first();
            segment2.setFirst(segment2.second());
            segment2.setSecond(temp);
        }

        double x1 = segment1.first().getX();
        double y1 = segment1.first().getY();
        double x2 = segment1.second().getX();
        double y2 = segment1.second().getY();

        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();

        double k1 = y1 == y2 ? 0 :(y2 - y1) / (x2 - x1);
        double k2 = y3 == y4 ? 0: (y4 - y3) / (x4 - x3);

        if (k1 == k2) {
            return null;
        }

        double b1 = y1 - k1 * x1;
        double b2 = y3 - k2 * x3;

        double x = (b2 - b1) / (k1 -  k2);
        double y = k1 * x + b1;

        if (!((x1 <= x4 && x4 <= x2) || (x1 <= x3 && x3 <= x2))) {
            return null;
        }

        return new Point2D(x, y);
    }

    static class Segment implements ISegment {
        I2DPoint first;
        I2DPoint second;

        Segment(I2DPoint first, I2DPoint second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public I2DPoint first() {
            return first;
        }

        @Override
        public I2DPoint second() {
            return second;
        }

        void setFirst(I2DPoint first) {
            this.first = first;
        }

        void setSecond(I2DPoint second) {
            this.second = second;
        }
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