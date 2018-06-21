package com.epam.homework.task26;

import com.akalji.SystemsOfLinearEquations.*;
import com.akalji.SystemsOfLinearEquations.exceptions.LinearEquationIncompatibleException;
import com.akalji.matrix.Matrix;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.*;

import static com.akalji.SystemsOfLinearEquations.PLUDecomposition.PLUC;

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
    private class Crosser implements Callable {
        private ISegment firstSegment;
        private ISegment secondSegment;

        @Override
        public Map.Entry<Double, I2DPoint> call() throws Exception {
            Matrix x;
            Matrix A = new Matrix(2, 2);
            Matrix b = new Matrix(2, 1);

            //Ax=b
            A.set(0, 0, firstSegment.first().getY() - firstSegment.second().getY());
            A.set(0, 1, firstSegment.first().getX() - firstSegment.second().getX());
            A.set(1, 0, secondSegment.first().getY() - secondSegment.second().getY());
            A.set(1, 1, secondSegment.first().getX() - secondSegment.second().getX());

            b.set(0, 0, firstSegment.first().getX() * firstSegment.second().getY() - firstSegment.second().getX() * firstSegment.first().getY());
            b.set(1, 0, secondSegment.first().getX() * secondSegment.second().getY() - secondSegment.second().getX() * secondSegment.first().getY());

            try {
                Solution solution = PLUC(A);
                x = SystemOfLinearEquation.SOLE(solution, b);
            } catch (LinearEquationIncompatibleException e) {
                return null;
            }
            return new AbstractMap.SimpleEntry<Double, I2DPoint>(x.getElement(0, 0), new Point(x.getElement(0, 0), x.getElement(1, 0)));
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

//        @Override
//        public String toString() {
//            return "Point{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
//        }

        @Override
        public int compareTo(I2DPoint o) {
            return compare(this, o);
        }
    }

}
