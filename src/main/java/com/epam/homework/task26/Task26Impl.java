package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {
    private static double EPS = 0.00001;

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentList = new ArrayList<>(segments);
        segmentList.sort(Comparator.comparingDouble(o -> Math.min(o.first().getX(), o.second().getX())));
        Set<I2DPoint> pointSet = new HashSet<>();
        double pointX = 0;
        boolean isFirstPointFound = false;
        for (int i = 0; i < segmentList.size() - 1; i++) {
            ISegment left = segmentList.get(i);
            if (isFirstPointFound && (Math.min(left.first().getX(), left.second().getX()) - pointX) > EPS) {
                break;
            }
            for (int j = i + 1; j < segmentList.size(); j++) {
                ISegment right = segmentList.get(j);
                if (isFirstPointFound && (Math.min(right.first().getX(), right.second().getX()) - pointX) > EPS) {
                    break;
                }
                Point pt = intersectionOfSegments(left, right);
                if (pt != null) {
                    if (isFirstPointFound) {
                        if (Math.abs(pt.getX() - pointX) <= EPS) {
                            pointSet.add(pt);
                        }
                        if (pointX - (pt.getX()) > EPS) {
                            pointSet.clear();
                            pointSet.add(pt);
                            pointX = pt.getX();
                        }
                    } else {
                        isFirstPointFound = true;
                        pointSet.add(pt);
                        pointX = pt.getX();
                    }
                }
            }
        }
        return pointSet;
    }

    private Point intersectionOfSegments(ISegment left, ISegment right) {
        double a1 = left.first().getY() - left.second().getY();
        double a2 = right.first().getY() - right.second().getY();
        double b1 = left.second().getX() - left.first().getX();
        double b2 = right.second().getX() - right.first().getX();
        double d = a1 * b2 - a2 * b1;
        if (Math.abs(d) < EPS) {
            return null;
        }
        double c1 = left.second().getY() * left.first().getX() - left.second().getX() * left.first().getY();
        double c2 = right.second().getY() * right.first().getX() - right.second().getX() * right.first().getY();
        double x = (b1 * c2 - b2 * c1) / d;
        double y = (a2 * c1 - a1 * c2) / d;

        if (Math.min(left.first().getX(), left.second().getX()) <= x &&
                x <= Math.max(left.first().getX(), left.second().getX()) &&
                Math.min(right.first().getX(), right.second().getX()) <= x &&
                x <= Math.max(right.first().getX(), right.second().getX()) &&

                Math.min(left.first().getY(), left.second().getY()) <= y &&
                y <= Math.max(left.first().getY(), left.second().getY()) &&
                Math.min(right.first().getY(), right.second().getY()) <= y &&
                y <= Math.max(right.first().getY(), right.second().getY())) {
            return new Point(x, y);
        }
        return null;
    }
}

class Point implements Task26.I2DPoint {
    private double x;
    private double y;
    private static double EPS = 0.00001;

    Point(double x, double y) {
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

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point anotherPt = (Point) o;
        return (this.x - anotherPt.getX()) < EPS &&
                (this.y - anotherPt.getY()) < EPS;
    }
}
