package com.epam.homework.task26;

import java.util.*;

public class Task26Implementation implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Double, Set<I2DPoint>> map = new TreeMap<>();
        List<ISegment> iSegmentList = new ArrayList<>(segments);
        for (int i = 0; i < iSegmentList.size(); i++) {
            for (int y = i + 1; y < iSegmentList.size(); y++) {
                I2DPoint intersectionPoint = getIntersection(iSegmentList.get(i), iSegmentList.get(y));
                if (intersectionPoint != null) {
                    addIntersectionPoint(map, intersectionPoint);
                }
            }
        }
        return map.firstEntry().getValue();
    }

    private void addIntersectionPoint(TreeMap<Double, Set<I2DPoint>> mapOfIntersectionPoints, I2DPoint point) {
        double mapKey = point.getX();
        if (mapOfIntersectionPoints.containsKey(mapKey)) {
            mapOfIntersectionPoints.merge(mapKey, mapOfIntersectionPoints.get(mapKey), (point1, point2) -> {
                mapOfIntersectionPoints.get(mapKey).add(point);
                        return mapOfIntersectionPoints.get(mapKey);
                    });
        } else {
            Set<I2DPoint> points = new HashSet<>();
            points.add(point);
            mapOfIntersectionPoints.put(mapKey, points);
        }
    }

    private I2DPoint getIntersection(ISegment firstSegment, ISegment secondSegment) {

        double x1 = firstSegment.first().getX();
        double y1 = firstSegment.first().getY();
        double x2 = firstSegment.second().getX();
        double y2 = firstSegment.second().getY();
        double x3 = secondSegment.first().getX();
        double y3 = secondSegment.first().getY();
        double x4 = secondSegment.second().getX();
        double y4 = secondSegment.second().getY();

        double a1 = -(firstSegment.second().getY() - firstSegment.first().getY());
        double b1 = (x2 - x1);
        double c1 = -(a1 * x1 + b1 * y1);

        double a2 = -(y4 - y3);
        double b2 = x4 - x3;
        double c2 = -(a2 * x3 + b2 * y3);

        double line1left = a2 * x1 + b2 * y1 + c2;
        double line1rigth = a2 * x2 + b2 * y2 + c2;

        double line2left = a1 * x3 + b1 * y3 + c1;
        double line2rigth = a1 * x4 + b1 * y4 + c1;

        if (line1left * line1rigth > 0 || line2left * line2rigth > 0) {
            return null;
        }

        double k = line1left / (line1left - line1rigth);
        return new IntersectionPoint(x1 + k * (x2 - x1), y1 + k * (y2 - y1));
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