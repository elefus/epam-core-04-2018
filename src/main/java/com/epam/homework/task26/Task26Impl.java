package com.epam.homework.task26;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

public class Task26Impl implements Task26 {
    private static double EPS = 0.00001;

    TreeSet<I2DPoint> T = new TreeSet<>(new Point());

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        Set<I2DPoint> result = new HashSet<>();
        TreeSet<I2DPoint> Q = segmentsIntersections(segments);
        while (!Q.isEmpty()) {
            processPoint(Q.first());
        }

        return result;
    }

    private TreeSet<I2DPoint> segmentsIntersections(Set<ISegment> segments) {
        TreeSet<I2DPoint> res = new TreeSet<>(new Point());
        for (ISegment segment:segments) {
            res.add(segment.first());
            res.add(segment.second());
        }
        return res;
    }

    private I2DPoint processPoint(I2DPoint q) {
        return new Point(0, 0);
    }


    @AllArgsConstructor
    @NoArgsConstructor
    class Point implements Task26.I2DPoint, Comparator<I2DPoint>, Comparable<I2DPoint> {
        private double x;
        private double y;

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public int compare(I2DPoint o1, I2DPoint o2) {
            if (o1.getX() - o2.getY() < EPS && o1.getY() - o2.getY() < EPS) {
                return 0;
            }
            if (o1.getX() - o2.getX() < EPS) {
                if (o1.getY() > o2.getY()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        @Override
        public int compareTo(I2DPoint o) {
            return compare(this,o);
        }
    }
}
