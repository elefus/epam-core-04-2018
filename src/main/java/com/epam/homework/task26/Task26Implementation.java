package com.epam.homework.task26;

import java.util.*;

public class Task26Implementation implements Task26 {

    private Map<ISegment, List<Double>> linesMap;

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        Set<I2DPoint> resultSet = new HashSet<>();
        linesMap = new TreeMap<>();

        double minAbsc = Double.MAX_VALUE;

        for (ISegment segment : segments) {
            getLineFromTheCoordinates(segment);
        }

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

    private I2DPoint getIntersectionPoint(ISegment first, ISegment second) {
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

    /**
     * line = Ax + By + C = 0
     * lineCoordinates list[0] - A
     * lineCoordinates list[1] - B
     * lineCoordinates list[2] - C
     * @param segment started set
     */
    private void getLineFromTheCoordinates(ISegment segment) {
        List<Double> lineCoordinates = new ArrayList<>();
        lineCoordinates.add(segment.first().getY() - segment.second().getY());
        lineCoordinates.add(segment.second().getX() - segment.first().getX());
        lineCoordinates.add((segment.first().getX() * segment.second().getY()) - (segment.first().getY() * segment.second().getX()));
        linesMap.put(segment, lineCoordinates);
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
