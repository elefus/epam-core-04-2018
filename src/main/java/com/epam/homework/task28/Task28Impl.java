package com.epam.homework.task28;

import java.util.Set;

public class Task28Impl implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        int length = lengthLap * numberLaps;

        for (Car car1 : cars) {
            for (Car car2 : cars) {
                numberOvertaking += howManyTimesOvertakes(car1, car2, length, lengthLap, numberLaps);
            }
        }

        return numberOvertaking;
    }

    private int howManyTimesOvertakes(Car car1, Car car2, int length, int lengthLap, int numberLaps) {
        if (car1.getSpeed() >= car2.getSpeed()) {
            int car1FinishTime = (numberLaps - (car1.getStartPosition() % lengthLap)) / car1.getSpeed();
            int lapsLeftForCar2 = numberLaps - (car2.getStartPosition() % lengthLap) - (car1FinishTime * car2.getSpeed());
            return (car1.getStartPosition() > car2.getStartPosition()) ? lapsLeftForCar2 / lengthLap + 1 : lapsLeftForCar2 / lengthLap;
        }

        return 0;
    }
}
