package com.epam.homework.task26;

import java.util.Set;

public class Task26Impl implements Task26{
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
        for (ISegment iSegment: segments) {
            for (ISegment iSegment2 :segments) {

            }


            I2DPoint first = iSegment.first();
            I2DPoint second = iSegment.second();
            double x1 = first.getX();
            double y1 = first.getY();

            double x2 = second.getX();
            double y2 = second.getY();

            double y;

            y = (x2 * y1 - x1 * y2 - (y1 - y2) * x)/(x2 - x1);

        }

    }

    public static boolean isLinesIntercepts(ISegment iSegment1, ISegment iSegment2) {
        I2DPoint first = iSegment1.first();
        I2DPoint second = iSegment.second();

        double vector1 = (end2.first - start2.first) * (start1.second - start2.second) - (end2.second - start2.second) * (start1.first - start2.first);
        double vector2 = (end2.first - start2.first) * (end1.second - start2.second) - (end2.second - start2.second) * (end1.first - start2.first);
        double vector3 = (end1.first - start1.first) * (start2.second - start1.second) - (end1.second - start1.second) * (start2.first - start1.first);
        double vector4 = (end1.first - start1.first) * (end2.second - start1.second) - (end1.second - start1.second) * (end2.first - start1.first);
        return ((vector1 * vector2 <= 0) && (vector3 * vector4 <= 0));
    }
}
