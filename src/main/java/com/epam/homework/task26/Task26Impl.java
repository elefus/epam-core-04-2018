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
                if (point != null) {
                    addIntersectionPoint(mapOfIntersections, point);
                }
            }
        }
        return mapOfIntersections.firstEntry().getValue();
    }

    private void addIntersectionPoint(TreeMap<Double, Set<I2DPoint>> mapOfIntersections, I2DPoint point) {

        double key = point.getX();
        if (!mapOfIntersections.containsKey(key)) {
            Set<I2DPoint> hashSet = new HashSet<>();
            hashSet.add(point);
            mapOfIntersections.put(key, hashSet);
        } else {
            // если уже есть такой ключ, добавляем в Set точку
            mapOfIntersections.merge(key, mapOfIntersections.get(key),
                    (a, b) -> {
                        // добавляем точку в Set
                        mapOfIntersections.get(key).add(point);
                        //возвращаем новый Set
                        return mapOfIntersections.get(key);
                    });
        }
    }


    private I2DPoint getIntersectionPoint(ISegment segment1, ISegment segment2) {

        Point resultPoint = new Point();

        double x1 = segment1.first().getX();
        double y1 = segment1.first().getY();
        double x2 = segment1.second().getX();
        double y2 = segment1.second().getY();

        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();

        double c = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (Math.abs(c) - 0 < 0.0000001) {
            if ((x2 == x4 || x2 == x3) & (y2 == y4 || y2 == y3)) {
                return new Point(x2, y2);
            }
            if ((x1 == x3 || x1 == x4) & (y1 == y3 || y1 == y4)) {
                return new Point(x1, y1);
            }
            return null;
        }


        //нахождение координат векторов
        double xv12 = x2 - x1;
        double xv13 = x3 - x1;
        double xv14 = x4 - x1;
        double yv12 = y2 - y1;
        double yv13 = y3 - y1;
        double yv14 = y4 - y1;

        double xv31 = x1 - x3;
        double xv32 = x2 - x3;
        double xv34 = x4 - x3;
        double yv31 = y1 - y3;
        double yv32 = y2 - y3;
        double yv34 = y4 - y3;
        //построение векторов
        double v1, v2, v3, v4;
        v1 = xv34 * yv31 - yv34 * xv31;
        v2 = xv34 * yv32 - yv34 * xv32;
        v3 = xv12 * yv13 - yv12 * xv13;
        v4 = xv12 * yv14 - yv12 * xv14;

        if ((v1 * v2) < 0 && (v3 * v4) < 0) {
            double a1 = y2 - y1;
            double a2 = y4 - y3;
            double b1 = x1 - x2;
            double b2 = x3 - x4;
            double c1 = (x1 * (y1 - y2) + y1 * (x2 - x1)) * (-1);
            double c2 = (x3 * (y3 - y4) + y3 * (x4 - x3)) * (-1);


            double d = (a1 * b2) - (b1 * a2);
            double dx = (c1 * b2) - (b1 * c2);
            double dy = (a1 * c2) - (c1 * a2);

            if (d != 0) {
                return new Point(dx / d, dy / d);
            }
        }
        return null;
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