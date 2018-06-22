package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> list = new ArrayList<>(segments);
        TreeMap<Double, Set<I2DPoint>> map = new TreeMap<>();
        Set<I2DPoint> hashSet = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                I2DPoint intersectionPoint = getIntersectionPoint(list.get(i), list.get(j));

                if (intersectionPoint != null) {
                    if (!map.containsKey(intersectionPoint.getX())) {
                        hashSet.add(intersectionPoint);
                        map.put(intersectionPoint.getX(), hashSet);
                    } else {
                        Set<I2DPoint> i2DPoints = map.get(intersectionPoint.getX());
                        i2DPoints.add(intersectionPoint);
                        map.put(intersectionPoint.getX(), i2DPoints);
                    }
                }
            }
        }
        return map.firstEntry().getValue();
    }


    private I2DPoint getIntersectionPoint(ISegment segment1, ISegment segment2) {
        double x1 = segment1.first().getX();
        double x2 = segment1.second().getX();
        double y1 = segment1.first().getY();
        double y2 = segment1.second().getY();
        double x3 = segment2.first().getX();
        double x4 = segment2.second().getX();
        double y3 = segment2.first().getY();
        double y4 = segment2.second().getY();

        double a1 = -(y2 - y1);
        double a2 = -(y4 - y3);

        double b1 = x2 - x1;
        double b2 = x4 - x3;

        double c1 = -(a1 * x1 + b1 * y1);
        double c2 = -(a2 * x3 + b2 * y3);

        if ((a2 * x1 + b2 * y1 + c2) * (a2 * x2 + b2 * y2 + c2) > 0 || (a1 * x3 + b1 * y3 + c1) * (a1 * x4 + b1 * y4 + c1) > 0)
            return null;

        double d = (a2 * x1 + b2 * y1 + c2) / ((a2 * x1 + b2 * y1 + c2) - (a2 * x2 + b2 * y2 + c2));
        return new Point2D(x1 + d * (x2 - x1), y1 + d * (y2 - y1));
    }

}

class Point2D implements Task26.I2DPoint {
    private double x;
    private double y;

    Point2D(double x, double y) {
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
