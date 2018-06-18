package com.epam.homework.task26;

import lombok.Data;
import lombok.Getter;

import java.util.*;

public class Task26class implements Task26 {

     @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<I2DPoint> intersections = new ArrayList<>();
        List<Segment> segmentsList = new ArrayList<>(segments.size());
        for (ISegment segment : segments) {
            segmentsList.add((Segment) segment);
        }
        for (int i = 0; i < segmentsList.size() - 1; i++) {
            for (int j = i+1; j < segmentsList.size(); j++) {
                Point inter = xPoint(segmentsList.get(i), segmentsList.get(j));
                if (inter != null) {
                    if (intersections.isEmpty() || inter.getX() == intersections.get(intersections.size() - 1).getX()) {
                        intersections.add(inter);
                    } else {
                        if (inter.getX() < intersections.get(intersections.size() - 1).getX()) {
                            intersections.clear();
                            intersections.add(inter);
                        }
                    }
                }
            }
        }
        return new HashSet<>(intersections);
    }

    public static Point xPoint(Segment segment1, Segment segment2) {
        boolean xDefinated = false;
        boolean yDefinated = false;
        double xX = 0;
        double xY = 0;
        IndexOfLine line1 = new IndexOfLine(segment1.first().getX(), segment1.second().getX(), segment1.first().getY(), segment1.second().getY());
        if (line1.xConst) {
            xX = segment1.first().getX();
            xDefinated = true;
        }
        if (line1.yConst) {
            xY = segment1.first().getY();
            yDefinated = true;
        }
        IndexOfLine line2 = new IndexOfLine(segment2.first().getX(), segment2.second().getX(), segment2.first().getY(), segment2.second().getY());
        if (line2.xConst && !xDefinated) {
            xX = segment2.first().getX();
            xDefinated = true;
        }
        if (line2.yConst && !yDefinated) {
            xY = segment2.first().getY();
            yDefinated = true;
        }
        double k1 = line1.getK();
        double k2 = line2.getK();
        double b1 = line1.getB();
        double b2 = line2.getB();
        if (k1 == k2 && b1==b2) return null;
        if (!xDefinated) {
            xX = (b2 - b1) / (k1 - k2);
        }
                if (!yDefinated) {
            xY = (k1 * b2 - k2 * b1) / (k1 - k2);
        }
        if (isInSegment(xX, xY, segment1, segment2)) {
            Point intersection = new Point();
            intersection.setX(xX);
            intersection.setY(xY);
            return intersection;
        } else return null;

    }

    @Getter
    static class IndexOfLine {
        double k;
        double b;
        boolean xConst;
        boolean yConst;

        public IndexOfLine (double x1, double x2, double y1,double y2){
            xConst = x1 == x2;
            yConst = y1 == y2;
            k = x1==x2 ? 0 : (y2-y1)/(x2-x1);
            b = y1 - k*x1;
    }
    }

    public static boolean isInSegment(double xX, double xY, Segment segment1, Segment segment2) {
        if (xX < Math.min(segment1.first().getX(), segment1.second().getX())  || xX > Math.max(segment1.first().getX(), segment1.second().getX())){
            return false;
        }
        if (xX < Math.min(segment2.first().getX(), segment2.second().getX())  || xX > Math.max(segment2.first().getX(), segment2.second().getX())) {
            return false;
        }
        if (xY < Math.min(segment1.first().getY(), segment1.second().getY())  || xY > Math.max(segment1.first().getY(), segment1.second().getY())){
            return false;
        }
        if (xY < Math.min(segment2.first().getY(), segment2.second().getY())  || xY > Math.max(segment2.first().getY(), segment2.second().getY())) {
             return false;
        }
        return true;
    }

    static class Segment implements ISegment {
        Point first;
        Point second;

        @Override
        public I2DPoint first() {
            return first;
        }

        @Override
        public I2DPoint second() {
            return second;
        }
    }

    @Data
    static class Point implements I2DPoint {
        double x;
        double y;
    }
}
