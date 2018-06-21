package com.epam.homework.task26;

import java.util.*;

public class Task26Implementation implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        Set<I2DPoint> resultSet = new HashSet<>();
        Map<ISegment, List<Double>> linesMap = new TreeMap<>();
        double minAbsc = Double.MAX_VALUE;
        Iterator<ISegment> iterator = linesMap.keySet().iterator();
        while (iterator.hasNext()) {
            ISegment firstLineCoordinates = iterator.next();
            if (iterator.hasNext()) {
                ISegment secondLineCoordinates = iterator.next();
                    I2DPoint intersectionPoint = getIntersectionPoint(firstLineCoordinates, secondLineCoordinates);
                    if (intersectionPoint != null && Double.compare(minAbsc, intersectionPoint.getX()) > 0) {
                        minAbsc = intersectionPoint.getX();
                    }
                    resultSet.add(intersectionPoint);
            }
        }

        double min = minAbsc;
        resultSet.removeIf(e -> e.getX() > min);

        return resultSet;
    }

    I2DPoint getIntersectionPoint(ISegment first, ISegment second) {
        double x;
        double y;

        // параметры отрезков
       double a1 = first.first().getY() - first.second().getY();
       double b1 = first.second().getX() - first.first().getX();
       double a2 = second.first().getY() - second.second().getY();
       double b2 = second.second().getX() - second.first().getX();

        double d = a1 * b2 - a2 * b1;
        if ( d != 0 ) {
            double c1 = first.second().getY() * first.first().getX() - first.second().getX() * first.first().getY();
            double c2 = second.second().getY() * second.first().getX() - second.second().getX() * second.second().getY();
            x = (b1 * c2 - b2 * c1) / d;
            y = (a2 * c1 - a1 * c2) / d;
            return new IntersectionPoint(x, y);
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
            return 0;
        }

        @Override
        public double getY() {
            return 0;
        }
    }


}
