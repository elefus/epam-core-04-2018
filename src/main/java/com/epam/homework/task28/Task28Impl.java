package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task28Impl implements Task28 {
    private int numOfOvertakes = 0;

    synchronized private void increaseNumOfOvertakes() {
        numOfOvertakes++;
    }

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        numOfOvertakes = 0;
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ArrayList<Car> listOfCar = new ArrayList<>(cars);
        for (int i = 0; i < listOfCar.size(); i++) {
            for (int j = i; j < listOfCar.size(); j++) {
                if (i != j) {
                    service.submit(new Race(listOfCar.get(i), listOfCar.get(j), lengthLap, numberLaps));
                }
            }
        }
        service.shutdown();
        if (!service.isTerminated()){
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return numOfOvertakes;
    }

    private class Race implements Runnable {
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
        public void run() {
            if(A.getSpeed()>B.getSpeed()){
                if (A.getStartPosition()>B.getStartPosition()){
                    increaseNumOfOvertakes();
                }
                
            }else {
                if (B.getStartPosition()>A.getStartPosition()){
                    increaseNumOfOvertakes();
                }

            }
        }

    }
}
