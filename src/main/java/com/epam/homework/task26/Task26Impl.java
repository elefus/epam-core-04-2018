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
        Set<I2DPoint> segmentEdgePointCrossing = countStopPointCrossing(segments);
        Set<I2DPoint> otherPointCrossing = iterateOverStopPoints(getStopPoints(segments));
        otherPointCrossing.addAll(segmentEdgePointCrossing);
        return getMinI2DPoints(otherPointCrossing);
    }

    private Set<I2DPoint> countStopPointCrossing(Set<ISegment> segments) {
        Map<I2DPoint, Integer> pointCounter = new HashMap<>();
        segments.forEach(item -> {
            pointCounter.merge(item.first(), 1, (a, b) -> a + b);
            pointCounter.merge(item.second(), 1, (a, b) -> a + b);
        });
        return pointCounter.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toSet());
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

        Set<I2DPoint> result = new HashSet<>();

        for (Map.Entry<Double, List<ISegment>> entry : stopPointsMap.entrySet()) {
            currentSegmentList = getSegmentsSortedByY(nextStepSegments, entry);
            Set<ISegment> crossSegments = getCrossingSegments(prevSegmentList, currentSegmentList);
            result.addAll(getCrossingPoints(crossSegments));

            if (!result.isEmpty()) {
                break;
            }

            nextStepSegments.removeAll(nextStepSegments.stream().filter(item -> item.second().getX() >= entry.getKey()).collect(Collectors.toList()));
            nextStepSegments.addAll(entry.getValue().stream().filter(item -> item.first().getX() >= entry.getKey()).collect(Collectors.toList()));

            prevSegmentList = getSegmentsSortedByY(nextStepSegments, entry);
        }
        return result;
    }

    private static Set<I2DPoint> getCrossingPoints(Set<ISegment> crossSegments) {
        if(!crossSegments.isEmpty()) {
            Set<I2DPoint> result = checkLineCrossingSet(crossSegments
                    .stream()
                    .map(Task26Impl::getLine)
                    .collect(Collectors.toSet()));
            return result;
        }
        return new HashSet<>();
    }

    private static Set<I2DPoint> getMinI2DPoints(Set<I2DPoint> result) {
        double min = result.stream().mapToDouble(item -> item.getX()).min().orElse(Double.MAX_VALUE);
        return result.stream().filter(item -> item.getX() == min).collect(Collectors.toSet());
    }

//    private static boolean doubleEquals (double d1, double d2) {
//        return Math.abs(d1 - d2) <= 0.000001;
//    }
//
//    private static boolean doubleLt (double d1, double d2) {
//        return Math.abs(d1 - d2) <= 0.000001 || d1 < d2;
//    }
//
//    private static boolean doubleGt (double d1, double d2) {
//        return Math.abs(d1 - d2) <= 0.000001 || d1 > d2;
//    }

    private static Set<ISegment> getCrossingSegments(List<ISegment> prevSegmentList, List<ISegment> currentSegmentList) {
        Set<ISegment> crossSegments = new HashSet<>();
        for (int i = 0; i < prevSegmentList.size(); i++) {
            if (prevSegmentList.get(i) != currentSegmentList.get(i)) {
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
        List<Line> lineList = new ArrayList<>(lines);
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                i2DPoints.add(getLineCrossingPoint(lineList.get(i), lineList.get(j)));
            }
        }
        return i2DPoints;
    }

    private static double doubleRound(double value) {
        return (double)Math.round(value * 100000d) / 100000d;
    }

    private static I2DPoint getLineCrossingPoint(Line l1, Line l2) {
        double x = doubleRound((l2.getB() - l1.getB()) / (l1.getK() - l2.getK()));
        double y = doubleRound((l1.getK() * l2.getB() - l2.getK() * l1.getB()) / (l1.getK() - l2.getK()));
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
//        segmentSet.add(new SegmentImpl(new Point(0, 0), new Point(3, 3)));
//        segmentSet.add(new SegmentImpl(new Point(0, 3), new Point(3, 0)));
        segmentSet.add(new SegmentImpl(new Point(-4, -2), new Point(-2, 2)));
//        segmentSet.add(new SegmentImpl(new Point(-1, -2), new Point(2, 2)));
//        segmentSet.add(new SegmentImpl(new Point(-1, -2), new Point(-1, -2)));
//        segmentSet.add(new SegmentImpl(new Point(4, 3), new Point(11, 9)));
//        segmentSet.add(new SegmentImpl(new Point(2, 3), new Point(11, 9)));
        segmentSet.add(new SegmentImpl(new Point(100, 1), new Point(105, 4)));
        System.out.println(new Task26Impl().analyze(segmentSet));
    }
}
