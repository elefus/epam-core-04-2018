package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Task28Impl implements Task28 {
    private int numberOfOvertaking;

    synchronized private void increaseNumberOfOvertaking() {
        numberOfOvertaking++;
    }

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ArrayList<Car> listOfCar = new ArrayList<>(cars);

        List<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < listOfCar.size(); i++) {
            for (int j = i; j < listOfCar.size(); j++) {
                if (i != j) {
                    tasks.add(new Race(listOfCar.get(i), listOfCar.get(j), lengthLap, numberLaps));
                }
            }
        }
        List<Future<Object>> futures = new ArrayList<>();
        try {
            futures = service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isFinished;
        do {
            isFinished = true;
            for (Future<Object> future : futures) {
                if (!future.isDone()) {
                    isFinished = false;
                }
            }
        } while (!isFinished);

        service.shutdown();

        return numberOfOvertaking;
    }

    private class Race implements Callable {
        Car A;
        Car B;
        int lengthLap;
        int numberLaps;

        Race(Car a, Car b, int lengthLap, int numberLaps) {
            A = a;
            B = b;
            this.lengthLap = lengthLap;
            this.numberLaps = numberLaps;
        }

        @Override
        public Object call() {
            int distance = lengthLap * numberLaps;
            double timeA = distance / A.getSpeed();
            double timeB = distance / B.getSpeed();

            if (A.getSpeed() > B.getSpeed()) {
                if (A.getStartPosition() > B.getStartPosition()) {
                    increaseNumberOfOvertaking();
                }

                int v = (int) (distance - B.getSpeed() * timeA) / lengthLap;
                if (v > 0) {
                    for (int i = 0; i < v; i++) {
                        increaseNumberOfOvertaking();
                    }
                }

            } else {
                if (B.getStartPosition() > A.getStartPosition()) {
                    increaseNumberOfOvertaking();
                }
                int v = (int) (distance - A.getSpeed() * timeB) / lengthLap;
                if (v > 0) {
                    for (int i = 0; i < v; i++) {
                        increaseNumberOfOvertaking();
                    }
                }

            }
            return new Object();
        }

    }
}
