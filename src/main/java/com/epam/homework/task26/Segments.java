package com.epam.homework.task26;

import java.util.*;

public class Segments implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments){

        TreeMap<Double, Set<I2DPoint>> intersectionsMap = new TreeMap<>();

        List<ISegment> iSegmentList = new ArrayList<>(segments);

        for (int i = 0; i < iSegmentList.size(); i++) {
            for (int j = i + 1; j < iSegmentList.size(); j++) {

                I2DPoint point = getIntersectionPoint(iSegmentList.get(i), iSegmentList.get(j));

                if (point != null) {

                    double keyIntersectionsMap = point.getX();

                    if (!intersectionsMap.containsKey(keyIntersectionsMap)) {
                        Set<I2DPoint> hashSet = new HashSet<>();
                        hashSet.add(point);
                        intersectionsMap.put(keyIntersectionsMap, hashSet);

                    } else {
                        Set<I2DPoint> i2DPoints = intersectionsMap.get(keyIntersectionsMap);
                        i2DPoints.add(point);
                        intersectionsMap.put(keyIntersectionsMap, i2DPoints);
                    }
                }
            }
        }
        return intersectionsMap.firstEntry().getValue();
    }

    private I2DPoint getIntersectionPoint(ISegment seg1, ISegment seg2) {

        double x1 = seg1.first().getX();
        double y1 = seg1.first().getY();

        double x2 = seg1.second().getX();
        double y2 = seg1.second().getY();

        double x3 = seg2.first().getX();
        double y3 = seg2.first().getY();

        double x4 = seg2.second().getX();
        double y4 = seg2.second().getY();

        double a1 = -(seg1.second().getY() - seg1.first().getY());
        double b1 = (x2 - x1);
        double c1 = -(a1 * x1 + b1 * y1);

        double a2 = -(y4 - y3);
        double b2 = x4 - x3;
        double c2 = -(a2 * x3 + b2 * y3);

        double segmentStart1 = a2 * x1 + b2 * y1 + c2;
        double segmentEnd1 = a2 * x2 + b2 * y2 + c2;

        double segmentStart2 = a1 * x3 + b1 * y3 + c1;
        double segmentEnd2 = a1 * x4 + b1 * y4 + c1;

        if (segmentStart1 * segmentEnd1 > 0 || segmentStart2 * segmentEnd2 > 0) {
            return null;
        }

        double d = segmentStart1 / (segmentStart1 - segmentEnd2);

        return new Intersection(x1 + d * (x2 - x1), y1 + d * (y2 - y1));
    }

    private class Intersection implements I2DPoint {

        private double x;
        private double y;

        Intersection(double x, double y) {
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
