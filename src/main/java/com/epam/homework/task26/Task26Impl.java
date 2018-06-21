package com.epam.homework.task26;

import lombok.EqualsAndHashCode;

import java.util.*;


public class Task26Impl implements Task26 {
    /**
     * На плоскости задано N отрезков (2 <= N <= 20).
     * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
     * Использовать класс TreeMap.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        List<ISegment> segmentList = new ArrayList<>(segments);

        // В ключе храним абсциссу, а в значении - точки
        TreeMap<Double, Set<I2DPoint>> mapOfIntersections = new TreeMap<>();

        for (int i = 0; i < segmentList.size(); i++) {
            for (int j = i + 1; j < segmentList.size(); j++) {
                I2DPoint point = getIntersectionPoint(segmentList.get(i), segmentList.get(j));
                // добавляем точку в дерево
                if (point != null) {
                    double key = point.getX();
                    if (!mapOfIntersections.containsKey(key)) {
                        Set<I2DPoint> hashSet = new HashSet<>();
                        hashSet.add(point);
                        mapOfIntersections.put(key, hashSet);
                    } else {
                        Set<I2DPoint> i2DPoints = mapOfIntersections.get(key);
                        i2DPoints.add(point);
                        mapOfIntersections.put(key, i2DPoints);
                    }
                }
            }
        }
        return mapOfIntersections.firstEntry().getValue();
    }


    private I2DPoint getIntersectionPoint(ISegment segment1, ISegment segment2) {


        double x1 = segment1.first().getX();
        double x2 = segment1.second().getX();
        double y1 = segment1.first().getY();
        double y2 = segment1.second().getY();

        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();

        I2DPoint dir1 = new Point(x2 - x1, y2 - y1);
        I2DPoint dir2 = new Point(x4 - x3, y4 - y3);

        double a1 = -dir1.getY();
        double b1 = dir1.getX();
        double a2 = -dir2.getY();
        double b2 = dir2.getX();

        double d1 = -(a1 * x1 + b1 * y1);

        double d2 = -(a2 * x3 + b2 * y3);

        double seg1_start = a2 * x1 + b2 * y1 + d2;
        double seg1_end = a2 * x2 + b2 * y2 + d2;

        double seg2_start = a1 * x3 + b1 * y3 + d1;
        double seg2_end = a1 * x4 + b1 * y4 + d1;

        if (seg1_start * seg1_end > 0 || seg2_start * seg2_end > 0)
            return null;

        double u = seg1_start / (seg1_start - seg1_end);
        return new Point(x1 + u * b1, y1 + u * dir1.getY());
    }
}


@EqualsAndHashCode
class Point implements Task26.I2DPoint {
    private double x;
    private double y;

    public Point() {
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Значение абсциссы
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Значение ординаты
     */
    @Override
    public double getY() {
        return y;
    }
}