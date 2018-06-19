package com.epam.homework.task26;

import java.util.*;

public class Task26Implementation implements Task26 {

    private Set<I2DPoint> resultSet;
    private Map<ISegment, List<Double>> linesMap;

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        resultSet = new HashSet<>();
        linesMap = new TreeMap<>();

        for (ISegment segment : segments) {
            getLineFromTheCoordinates(segment);
        }

        

        return resultSet;
    }

    private boolean isParalel(List<Double> firstLineCoordinates, List<Double> secondLineCoordinates) {
        return Double.compare(firstLineCoordinates.get(0), secondLineCoordinates.get(0)) == 1;
    }
    private boolean isPerpendicular(List<Double> firstLineCoordinates, List<Double> secondLineCoordinates) {
        return Double.compare(firstLineCoordinates.get(0), (-1 / secondLineCoordinates.get(0))) == 1;
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
}
