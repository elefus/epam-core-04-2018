package com.epam.homework.task28;


import java.util.*;

public class Task28Impl implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        List<Car> carList = new ArrayList<>(cars);
        carList.sort(Comparator.comparingInt(Car::getSpeed));

        int numberOvertaking = 0;
        for (int i = carList.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                numberOvertaking += getNumberOvertakingForPair(carList.get(i), carList.get(j), lengthLap, numberLaps);
            }
        }
        return numberOvertaking;
    }

    private int getNumberOvertakingForPair(Car fasterCar, Car slowerCar, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        if (fasterCar.getSpeed() != slowerCar.getSpeed()) {
            numberOvertaking += numberLaps - numberLaps * slowerCar.getSpeed() / fasterCar.getSpeed() - 1;
        }
        if (fasterCar.getStartPosition() > slowerCar.getStartPosition()) {
            numberOvertaking++;
        }
        return numberOvertaking;
    }

}

