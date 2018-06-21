package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentsAsList = new ArrayList<>(segments);
        TreeMap<Double, Set<I2DPoint>> intersectionMap = new TreeMap<>();

        for (int i = 0; i < segmentsAsList.size(); i++) {
            for (int j = i + 1; j < segmentsAsList.size(); j++) {
                I2DPoint currentPoint = intersectionDot(segmentsAsList.get(i), segmentsAsList.get(j));
                if (currentPoint != null) {
                    addIntersectionPoint(intersectionMap, currentPoint);
                }
            }
        }
        return intersectionMap.firstEntry().getValue();
    }

    private I2DPoint intersectionDot(ISegment segment1, ISegment segment2) {
        double x1 = segment1.first().getX();
        double y1 = segment1.first().getY();
        double x2 = segment1.second().getX();
        double y2 = segment1.second().getY();
        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();
        //направляющие векторы
        Point seg1Direction = new Point(x2 - x1, y2 - y1);
        Point seg2Direction = new Point(x4 - x3, y4 - y3);
        //уравнения прямых проходящих через отрезки
        double a1 = -seg1Direction.getY();
        double b1 = seg1Direction.getX();
        double d1 = -(a1 * x1 + b1 * y1);
        double a2 = -seg2Direction.getY();
        double b2 = seg2Direction.getX();
        double d2 = -(a2 * x2 + b2 * y2);

        double seg12Start = a2 * x1 + b2 * y1 + d2;
        double seg1End = a2 * x2 + b2 * y2 + d2;
        double seg2Start = a1 * x3 + b1 * y3 + d1;
        double seg2End = a1 * x4 + b1 * y4 + d1;

        //если концы одного отрезка имеют один знак, значит он в одной полуплоскости и пересечения нет.
        if ((seg12Start * seg1End >= 0) || (seg2Start * seg2End >= 0))
            return null;

        double u = seg12Start / (seg12Start - seg1End);

        return new Point(x1 + u * seg1Direction.getX(), y1 + u * seg1Direction.getY());
    }

    private void addIntersectionPoint(TreeMap<Double, Set<I2DPoint>> intersectionMap, I2DPoint point) {
        double key = point.getX();
        if (!intersectionMap.containsKey(key)) {
            Set<I2DPoint> hashSet = new HashSet<>();
            hashSet.add(point);
            intersectionMap.put(key, hashSet);
        } else {
            intersectionMap.merge(key, intersectionMap.get(key),
                    (a, b) -> {
                        intersectionMap.get(key).add(point);
                        return intersectionMap.get(key);
                    });
        }
    }

    public class Point implements I2DPoint {
        private double x;
        private double y;

        Point(double x, double y) {
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


