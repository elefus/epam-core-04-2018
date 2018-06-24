package com.epam.homework.task26;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentList = new ArrayList<>(segments);
        TreeMap<Double, Set<I2DPoint>> intersectionsMap = new TreeMap<>();

        for (int i = 0; i < segmentList.size(); i++) {
            for (int j = i + 1; j < segmentList.size(); j++) {
                I2DPoint interPoint = intersection(segmentList.get(i), segmentList.get(j));
                if(interPoint != null) {
                    if (!intersectionsMap.containsKey(interPoint.getX())) {
                        Set<I2DPoint> interSet = new HashSet<>();
                        interSet.add(interPoint);
                        intersectionsMap.put(interPoint.getX(), interSet);
                    } else {
                        Set<I2DPoint> interSet = intersectionsMap.get(interPoint.getX());
                        interSet.add(interPoint);
                        intersectionsMap.put(interPoint.getX(), interSet);
                    }
                }
            }
        }

        return intersectionsMap.firstEntry().getValue();
    }

    private I2DPoint intersection(ISegment seg1, ISegment seg2) {
        double x1 = seg1.first().getX();
        double y1 = seg1.first().getY();
        double x2 = seg1.second().getX();
        double y2 = seg1.second().getY();
        double x3 = seg2.first().getX();
        double y3 = seg2.first().getY();
        double x4 = seg2.second().getX();
        double y4 = seg2.second().getY();

        I2DPoint dir1 = new Point2D(x2 - x1, y2 - y1);
        I2DPoint dir2 = new Point2D(x4 - x3, y4 - y3);

        double a1 = -dir1.getY();
        double b1 = dir1.getX();
        double a2 = -dir2.getY();
        double b2 = dir2.getX();

        double d1 = -(a1 * x1 + b1 * y1);
        double d2 = -(a2 * x3 + b2 * y3);

        double seg1Start = a2 * x1 + b2 * y1 + d2;
        double seg1End = a2 * x2 + b2 * y2 + d2;
        double seg2Start = a1 * x3 + b1 * y3 + d1;
        double seg2End = a1 * x4 + b1 * y4 + d1;

        if (seg1Start * seg1End > 0 || seg2Start * seg2End > 0)
            return null;

        double u = seg1Start / (seg1Start - seg1End);

        return new Point2D(x1 + u * dir1.getX(), y1 + u * dir1.getY());
    }

    @AllArgsConstructor
    @Getter
    private class Point2D implements I2DPoint {
        private double x;
        private double y;
    }
}
