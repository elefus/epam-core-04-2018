package com.epam.homework.task26;

import java.util.*;

public class Task26Impl2 implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentList = new ArrayList<>(segments);
        TreeMap<Double, Set<I2DPoint>> map = new TreeMap<>();

        for (int i = 0; i < segmentList.size(); i++) {
            for (int j = i + 1; j < segmentList.size(); j++) {

                I2DPoint intersectionPoint = getIntersectionPoint(segmentList.get(i), segmentList.get(j));

                if (intersectionPoint != null) {
                    if (!map.containsKey(intersectionPoint.getX())) {
                        Set<I2DPoint> set = new HashSet<>();
                        set.add(intersectionPoint);
                        map.put(intersectionPoint.getX(), set);
                    } else {
                        Set<I2DPoint> points = map.get(intersectionPoint.getX());
                        points.add(intersectionPoint);
                        map.put(intersectionPoint.getX(), points);
                    }
                }
            }
        }
        return map.firstEntry().getValue();
    }

    private I2DPoint getIntersectionPoint(ISegment firstSegment, ISegment secondSegment) {
        double x1 = firstSegment.first().getX();
        double x2 = firstSegment.second().getX();
        double y1 = firstSegment.first().getY();
        double y2 = firstSegment.second().getY();
        double x3 = secondSegment.first().getX();
        double x4 = secondSegment.second().getX();
        double y3 = secondSegment.first().getY();
        double y4 = secondSegment.second().getY();

        double a1 = -(y2 - y1);
        double a2 = -(y4 - y3);

        double b1 = x2 - x1;
        double b2 = x4 - x3;

        double c1 = -(a1 * x1 + b1 * y1);
        double c2 = -(a2 * x3 + b2 * y3);


        double startPointOfTheFirstSegment = a2 * x1 + b2 * y1 + c2;
        double endPointOfTheFirstSegment = a2 * x2 + b2 * y2 + c2;

        double startPointOfTheSecondSegment = a1 * x3 + b1 * y3 + c1;
        double endPointOfTheSecondSegment = a1 * x4 + b1 * y4 + c1;

        if (startPointOfTheFirstSegment * endPointOfTheFirstSegment > 0
                || startPointOfTheSecondSegment * endPointOfTheSecondSegment > 0) {
            return null;
        }

        double d = startPointOfTheFirstSegment / (startPointOfTheFirstSegment - endPointOfTheFirstSegment);
        return new I2DPointImpl(x1 + d * (x2 - x1), y1 + d * (y2 - y1));
    }
}





