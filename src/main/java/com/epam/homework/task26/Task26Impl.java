package com.epam.homework.task26;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Task26Impl implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        Set<I2DPoint> resultSet = new HashSet<>();
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ArrayList<ISegment> listOfSegments = new ArrayList<>(segments);
        List<Callable<I2DPoint>> tasks = new ArrayList<>();
        for (int i = 0; i < listOfSegments.size(); i++) {
            for (int j = i; j < listOfSegments.size(); j++) {
                if (i != j) {
                    tasks.add(new Cross(listOfSegments.get(i), listOfSegments.get(j)));
                }
            }
        }

        List<Future<I2DPoint>> futures = new ArrayList<>();
        try {
            futures = service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isFinished;
        do {
            isFinished = true;
            for (Future<I2DPoint> future : futures) {
                if (!future.isDone()) {
                    isFinished = false;
                }
            }
        } while (!isFinished);

        service.shutdown();
        return null;
    }

    @AllArgsConstructor
    private class Cross implements Callable {
        private ISegment A;
        private ISegment B;

        @Override
        public I2DPoint call() throws Exception {

            return new Point(0, 0);
        }
    }
}

@AllArgsConstructor
@EqualsAndHashCode
class Point implements Task26.I2DPoint {
    private double x;
    private double y;

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }
}
