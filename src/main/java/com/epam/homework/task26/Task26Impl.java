package com.epam.homework.task26;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.*;

public class Task26Impl implements Task26 {
    private static double EPS = 0.00001;

    TreeMap<Double, Set<I2DPoint>> intersections = new TreeMap<>();

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ArrayList<ISegment> listOfSegments = new ArrayList<>(segments);
        List<Callable<Map.Entry<Double, I2DPoint>>> tasks = new ArrayList<>();

        for (int i = 0; i < listOfSegments.size(); i++) {
            for (int j = i; j < listOfSegments.size(); j++) {
                if (i != j) {
                    tasks.add(new Crosser(listOfSegments.get(i), listOfSegments.get(j)));
                }
            }
        }

        List<Future<Map.Entry<Double, I2DPoint>>> futures = new ArrayList<>();
        try {
            futures = service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isFinished;
        do {
            isFinished = true;
            for (Future<Map.Entry<Double, I2DPoint>> future : futures) {
                if (!future.isDone()) {
                    isFinished = false;
                }
            }
        } while (!isFinished);

        service.shutdown();

        for (Future<Map.Entry<Double, I2DPoint>> future : futures) {
            try {
                Map.Entry<Double, I2DPoint> entry = future.get();
                if (entry != null) {
                    if (intersections.containsKey(entry.getKey())) {
                        intersections.get(entry.getKey()).add(entry.getValue());
                    } else {
                        intersections.put(entry.getKey(), new HashSet<I2DPoint>());
                        intersections.get(entry.getKey()).add(entry.getValue());
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        return intersections.firstEntry().getValue();
    }

    @AllArgsConstructor
    private class Crosser implements Callable<Map.Entry<Double, I2DPoint>> {
        private ISegment firstSegment;
        private ISegment secondSegment;

        @Override
        public AbstractMap.SimpleEntry<Double, I2DPoint> call() throws Exception {
            double x1A = firstSegment.first().getX();
            double y1A = firstSegment.first().getY();
            double x2A = firstSegment.second().getX();
            double y2A = firstSegment.second().getY();
            double x1B = secondSegment.first().getX();
            double y1B = secondSegment.first().getY();
            double x2B = secondSegment.second().getX();
            double y2B = secondSegment.second().getY();


            double c = (y2B - y1B) * (x2A - x1A) - (x2B - x1B) * (y2A - y1A);
            if (Math.abs(c) - 0 < 0.0000001) {

                if ((x2A == x2B || x2A == x1B) & (y2A == y2B || y2A == y1B)) {
                    return new AbstractMap.SimpleEntry<>(x2A, new Point(x2A, y2A));
                }
                if ((x1A == x1B || x1A == x2B) & (y1A == y1B || y1A == y2B)) {
                    return new AbstractMap.SimpleEntry<>(x1A, new Point(x1A, y1A));
                }
                return null;
            }

            //
            double A1 = -(y2A - y1A);
            double B1 = (x2A - x1A);
            double C1 = -(A1 * x1A + B1 * y1A);

            double A2 = -(y2B - y1B);
            double B2 = x2B - x1B;
            double C2 = -(A2 * x1B + B2 * y1B);

            double segment1Start = A2 * x1A + B2 * y1A + C2;
            double segment1End = A2 * x2A + B2 * y2A + C2;

            double segment2Start = A1 * x1B + B1 * y1B + C1;
            double segment2End = A1 * x2B + B1 * y2B + C1;

            if (segment1Start * segment1End > 0 || segment2Start * segment2End > 0) {
                return null;
            }

            double k = segment1Start / (segment1Start - segment1End);
            return new AbstractMap.SimpleEntry<>(x1A + k * (x2A - x1A), new Point(x1A + k * (x2A - x1A), y1A + k * (y2A - y1A)));
        }
    }

    @AllArgsConstructor
    static class Segment implements ISegment {
        private final I2DPoint first;
        private final I2DPoint second;


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
            Segment segment = (Segment) o;
            return Objects.equals(first, segment.first) &&
                    Objects.equals(second, segment.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    @AllArgsConstructor
    static class Point implements Task26.I2DPoint, Comparator<I2DPoint>, Comparable<I2DPoint> {
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
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(I2DPoint o) {
            return compare(this, o);
        }
    }
}
