package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        List<Car> carsList = new ArrayList<>(cars);
        carsList.sort(Comparator.comparingInt(Car::getSpeed));

        int overtakes = 0;
        for (int i = 0; i < carsList.size() - 1; i++) {
            for (int j = i + 1; j < carsList.size(); j++) {
                overtakes += getOvertakesForPair(carsList.get(i), carsList.get(j), numberLaps);
            }
        }
        return overtakes;

    }

    private int getOvertakesForPair(Car slowerCar, Car fasterCar, int numberLaps) {

        int overtakes = 0;
        if (fasterCar.getSpeed() != slowerCar.getSpeed()) {
            overtakes += numberLaps - numberLaps * slowerCar.getSpeed() / fasterCar.getSpeed() - 1;
        }
        if (fasterCar.getStartPosition() > slowerCar.getStartPosition()) {
            overtakes++;
        }
        return overtakes;

    }

}
