package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        List<Car> carList = new ArrayList<>(cars);

        int raceDistance = lengthLap * numberLaps;
        int overtaking = 0;

        for (int i = 0; i < carList.size(); i++) {

            Car carOne = carList.get(i);
            int timeOne = raceDistance / carOne.getSpeed();

            for (int j = i + 1; j < carList.size(); j++) {
                Car carTwo = carList.get(j);
                int timeTwo = raceDistance / carTwo.getSpeed();
                int differenceBetweenCars =
                        (raceDistance - Math.max(carOne.getSpeed(), carTwo.getSpeed()) * Math.min(timeOne, timeTwo));
                overtaking += Math.abs(differenceBetweenCars / lengthLap);

                if (carOne.getStartPosition() < carTwo.getStartPosition()) {
                    if (carTwo.getSpeed() > carOne.getSpeed()) {
                        overtaking += 1;
                    }
                }
                if (carOne.getStartPosition() > carTwo.getStartPosition()) {
                    if (carTwo.getSpeed() < carOne.getSpeed()) {
                        overtaking += 1;
                    }
                }
            }
        }
        return overtaking;
    }
}