package com.epam.homework.task26;

import java.util.*;
import java.util.stream.Collectors;

public class Task26Implementation implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Double, I2DPoint> map = new TreeMap<>(Double::compare);
        List<ISegment> iSegmentList = new ArrayList<>(segments);
        for (int i = 0; i < iSegmentList.size()-1; i++) {
            for (int y = i + 1; y < iSegmentList.size(); y++) {
                I2DPoint intersectionPoint = getIntersection(iSegmentList.get(i), iSegmentList.get(y));
                if (intersectionPoint != null) {
                    map.put(intersectionPoint.getX(), intersectionPoint);
                }
            }
        }
        return map.keySet().stream().filter(key -> key.equals(map.firstKey())).map(map::get).collect(Collectors.toSet());
    }

    private I2DPoint getIntersection(ISegment first, ISegment second) {

        // параметры отрезков
       double a1 = first.first().getY() - first.second().getY();
       double b1 = first.second().getX() - first.first().getX();
       double a2 = second.first().getY() - second.second().getY();
       double b2 = second.second().getX() - second.first().getX();

        double d = a1 * b2 - a2 * b1;

        if ( d != 0 ) {

            double c1 = first.second().getY() * first.first().getX() - first.second().getX() * first.first().getY();
            double c2 = second.second().getY() * second.first().getX() - second.second().getX() * second.second().getY();

            return new IntersectionPoint((b1 * c2 - b2 * c1) / d, (a2 * c1 - a1 * c2) / d);
        }
        else {
            return null;
        }
    }

    private class IntersectionPoint implements I2DPoint {

        private double x;
        private double y;

        IntersectionPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }
    }
}