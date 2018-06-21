package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CarRacing implements Task28{

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        List<Car> subCars = new ArrayList<>(cars);
        int countOvertaking = 0;

        for (int numberCar1 = 0; numberCar1 < subCars.size(); numberCar1++) {
            for (int numberCar2 = numberCar1 + 1; numberCar2 < subCars.size(); numberCar2++) {
                countOvertaking += getNumberOvertakingWithTwoCars(
                        subCars.get(numberCar1), subCars.get(numberCar2), lengthLap, numberLaps);
            }
        }
        return countOvertaking;
    }

    private int getNumberOvertakingWithTwoCars(Car firstCar, Car secondCar, int lengthLap, int numberLaps) {
        int countOvertakingWithTwoCars = 0;

        int firstCarTime = lengthLap * numberLaps / firstCar.getSpeed();
        int difference = lengthLap * numberLaps - secondCar.getSpeed() * firstCarTime;

        countOvertakingWithTwoCars += Math.abs(difference / lengthLap);

        if (firstCar.getStartPosition() < secondCar.getStartPosition()) {
            if (firstCar.getSpeed() < secondCar.getSpeed()) {
                ++countOvertakingWithTwoCars;
            }
        }
        if (firstCar.getStartPosition() > secondCar.getStartPosition()) {
            if (firstCar.getSpeed() > secondCar.getSpeed()) {
                ++countOvertakingWithTwoCars;
            }
        }
        return countOvertakingWithTwoCars;
    }
}
