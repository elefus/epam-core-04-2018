package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        List<Car> carsL = new ArrayList<>(cars);
        int numOfOvertakes = 0;
        int raceLength = lengthLap * numberLaps;

        for (int i = 0; i < carsL.size(); i++) {
            Car car1 = carsL.get(i);
            double timeCar1 = raceLength / car1.getSpeed();

            for (int j = i + 1; j < carsL.size(); j++) {
                Car car2 = carsL.get(j);
                double timeCar2 = raceLength / car1.getSpeed();
                numOfOvertakes += (int) (raceLength - (Math.min(car1.getSpeed(), car2.getSpeed()) * (Math.min(timeCar1, timeCar2)))) / lengthLap;

                if ((car1.getStartPosition() < car2.getStartPosition() && car1.getSpeed() < car2.getSpeed())
                        || (car1.getStartPosition() > car2.getStartPosition() && car1.getSpeed() > car2.getSpeed())) {
                    numOfOvertakes++;
                }
            }
        }

        return numOfOvertakes;

    }
}
