package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        List<Car> carList = new ArrayList<>(cars);
        for (int i = 0; i < carList.size(); i++) {
            for (int j = i + 1; j < carList.size(); j++) {
                numberOvertaking += getNumberOvertakingInPair(carList.get(i), carList.get(j), lengthLap, numberLaps);
            }
        }

        return numberOvertaking;
    }

    private int getNumberOvertakingInPair(Car firstCar, Car secondCar, int lengthLap, int numberLaps) {
        int numberOvertakingInPair = 0;
        int distanceLength = lengthLap * numberLaps;

        int firstCarTime = distanceLength / firstCar.getSpeed();
        int secondCarTime = distanceLength / secondCar.getSpeed();


        int difference = distanceLength - Math.min(firstCar.getSpeed(), secondCar.getSpeed()) * Math.min(firstCarTime, secondCarTime);

        numberOvertakingInPair += Math.abs(difference / lengthLap);

        if ((firstCar.getStartPosition() < secondCar.getStartPosition() && firstCar.getSpeed() < secondCar.getSpeed()) ||
            (firstCar.getStartPosition() > secondCar.getStartPosition() && firstCar.getSpeed() > secondCar.getSpeed())) {
            numberOvertakingInPair++;
        }

        return numberOvertakingInPair;
    }
}
