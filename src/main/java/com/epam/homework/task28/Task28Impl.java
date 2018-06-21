package com.epam.homework.task28;

import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;

        for (Car car1 : cars) {
            for (Car car2 : cars) {
                numberOvertaking += howManyTimesOvertakes(car1, car2, lengthLap, numberLaps);
            }
        }

        return numberOvertaking;
    }

    private int howManyTimesOvertakes(Car car1, Car car2, int lengthLap, int numberLaps) {
        if (car1.getSpeed() > car2.getSpeed()) {
            int length = lengthLap * numberLaps;
            int lapsOfCar2WhenCar1IsDone = ((length / car1.getSpeed()) * car2.getSpeed()) / lengthLap;
            return numberLaps / lapsOfCar2WhenCar1IsDone;
        }

        return 0;
    }
}