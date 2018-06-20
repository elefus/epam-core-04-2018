package com.epam.homework.task26;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class Task26Impl implements Task26 {

    final static Map<ISegment, Line> lineMap = new HashMap<>();

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        System.out.println(iterateOverStopPoints(getStopPoints(segments)));
        return null;
    }

    private static TreeMap<Double, List<ISegment>> getStopPoints(Set<ISegment> segments) {
        TreeMap<Double, List<ISegment>> stopSegments = new TreeMap<>();
        segments.forEach(segment -> {
            List<ISegment> segmentList = new ArrayList<>();
            segmentList.add(segment);
            stopSegments.merge(segment.first().getX(), segmentList, (k, v) -> {
                k.addAll(v);
                return k;
            });
            stopSegments.merge(segment.second().getX(), segmentList, (k, v) -> {
                k.addAll(v);
                return k;
            });
        });
        return stopSegments;
    }

    private static Set<I2DPoint> iterateOverStopPoints(TreeMap<Double, List<ISegment>> stopPointsMap) {
        List<ISegment> prevSegmentList = new ArrayList<>();
        List<ISegment> currentSegmentList = new ArrayList<>();
        Set<ISegment> nextStepSegments = new HashSet<>();
        for (Map.Entry<Double, List<ISegment>> entry : stopPointsMap.entrySet()) {
            currentSegmentList = getSegmentsSortedByY(nextStepSegments, entry);
            Set<ISegment> crossSegments = getCrossingSegments(prevSegmentList, currentSegmentList);
            Set<I2DPoint> result = getCrossingPoints(crossSegments);

            if (result != null) return result;

            nextStepSegments.removeAll(nextStepSegments.stream().filter(item -> item.second().getX() <= entry.getKey()).collect(Collectors.toList()));
            nextStepSegments.addAll(entry.getValue().stream().filter(item -> item.first().getX() <= entry.getKey()).collect(Collectors.toList()));

            prevSegmentList = getSegmentsSortedByY(nextStepSegments, entry);
        }
        return new HashSet<>();
    }

    private static Set<I2DPoint> getCrossingPoints(Set<ISegment> crossSegments) {
        if(!crossSegments.isEmpty()) {
            Set<I2DPoint> result = checkLineCrossingSet(crossSegments
                    .stream()
                    .map(Task26Impl::getLine)
                    .collect(Collectors.toSet()));
            double min = result.stream().mapToDouble(item -> item.getX()).min().orElse(Double.MAX_VALUE);
            return result.stream().filter(item -> Math.abs(item.getX() - min) <= 0.000001).collect(Collectors.toSet());
        }
        return null;
    }

    private static Set<ISegment> getCrossingSegments(List<ISegment> prevSegmentList, List<ISegment> currentSegmentList) {
        Set<ISegment> crossSegments = new HashSet<>();
        for (int i = 0; i < prevSegmentList.size(); i++) {
            if (!prevSegmentList.get(i).equals(currentSegmentList.get(i))) {
                crossSegments.add(prevSegmentList.get(i));
                crossSegments.add(currentSegmentList.get(i));
            }
        }
        return crossSegments;
    }

    private static List<ISegment> getSegmentsSortedByY(Set<ISegment> nextStepSegments, Map.Entry<Double, List<ISegment>> entry) {
        return nextStepSegments
                .stream()
                .sorted(Comparator.comparingDouble(i -> getYofX(i, entry.getKey())))
                .collect(Collectors.toList());
    }

    private static double getYofX(ISegment segment, double x) {
        Line line = getLine(segment);
        return line.getK() * x + line.getB();
    }

    private static Line getLine(ISegment segment) {
        return lineMap.computeIfAbsent(segment, Task26Impl::computeLineParam);
    }

    private static Line computeLineParam(ISegment segment) {
        double x1 = segment.first().getX();
        double y1 = segment.first().getY();
        double x2 = segment.second().getX();
        double y2 = segment.second().getY();

        double k = (y2 - y1) / (x2 - x1);
        double b = (y1 * x2 - y2 * x1) / (x2 - x1);
        return new Line(k, b);
    }

    private static Set<I2DPoint> checkLineCrossingSet(Set<Line> lines) {
        Set<I2DPoint> i2DPoints = new HashSet<>();
        lines.forEach(l1 -> lines.forEach(l2 ->  {
            if (l1 != l2)
                i2DPoints.add(getLineCrossingPoint(l1, l2));
        }));
        return i2DPoints;
    }

    private static I2DPoint getLineCrossingPoint(Line l1, Line l2) {
        double x = (l2.getB() - l1.getB()) / (l1.getK() - l2.getK());
        double y = (l1.getK() * l2.getB() - l2.getK() * l1.getB()) / (l1.getK() - l2.getK());
        return new Point(x, y);
    }


    static class SegmentImpl implements ISegment {
        private final I2DPoint first;
        private final I2DPoint second;

        public SegmentImpl(I2DPoint first, I2DPoint second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public I2DPoint first() {
            return first;
        }

        @Override
        public I2DPoint second() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SegmentImpl segment = (SegmentImpl) o;
            return Objects.equals(first, segment.first) &&
                    Objects.equals(second, segment.second);
        }

        @Override
        public int hashCode() {

            return Objects.hash(first, second);
        }
    }

    static class Point implements I2DPoint {
        private final double x;
        private final double y;

        public Point(double x, double y) {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Setter
    @Getter
    @ToString
    static class Line {
        private final double k;
        private final double b;

        public Line(double k, double b) {
            this.k = k;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Set<ISegment> segmentSet = new HashSet<>();
        segmentSet.add(new SegmentImpl(new Point(0, 0), new Point(3, 3)));
        segmentSet.add(new SegmentImpl(new Point(0, 3), new Point(3, 0)));
        segmentSet.add(new SegmentImpl(new Point(-1, -2), new Point(2, 2)));
        segmentSet.add(new SegmentImpl(new Point(4, 3), new Point(11, 9)));
        segmentSet.add(new SegmentImpl(new Point(2, 3), new Point(11, 9)));
        segmentSet.add(new SegmentImpl(new Point(100, 1), new Point(105, 4)));
        new Task26Impl().analyze(segmentSet);
    }
}
