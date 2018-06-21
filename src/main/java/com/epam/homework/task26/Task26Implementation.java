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

        Iterator<List<Double>> iterator = linesMap.values().iterator();
        while (iterator.hasNext()) {
            List<Double> firstLineCoordinates = iterator.next();
            if (iterator.hasNext()) {
                List<Double> secondLineCoordinates = iterator.next();
                if (!areParallel(firstLineCoordinates, secondLineCoordinates)) {
                    I2DPoint intersectionPoint = getIntersectionPoint(firstLineCoordinates, secondLineCoordinates);
                    if (Double.compare(minAbsc, intersectionPoint.getX()) > 0) {
                        minAbsc = intersectionPoint.getX();
                    }
                    resultSet.add(intersectionPoint);
                }
            }
        }

        double min = minAbsc;
        resultSet.removeIf(e -> e.getX() > min);

        return resultSet;
    }

    private I2DPoint getIntersectionPoint(List<Double> firstLineCoordinates, List<Double> secondLineCoordinates) {
        double x;
        double y;

        // выражаем
        x = (firstLineCoordinates.get(1) + firstLineCoordinates.get(2)) / - firstLineCoordinates.get(0);

        // считаем
        y = secondLineCoordinates.get(0)*x+secondLineCoordinates.get(2) / - secondLineCoordinates.get(1);
        x = secondLineCoordinates.get(1)*y+secondLineCoordinates.get(2) / - secondLineCoordinates.get(0);

        return new IntersectionPoint(x, y);
    }

    private boolean areParallel(List<Double> firstLineCoordinates, List<Double> secondLineCoordinates) {
        return Double.compare(firstLineCoordinates.get(0), secondLineCoordinates.get(0)) == 0;
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
