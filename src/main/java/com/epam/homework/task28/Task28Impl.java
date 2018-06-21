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
            int car1FinishTime = (((length - car1.getStartPosition()) / car1.getSpeed()));
            int car2PosWhenCar1Finished = car2.getSpeed() * car1FinishTime + car2.getStartPosition();
            int car2NumLaps = car2PosWhenCar1Finished / lengthLap;
            return numberLaps / car2NumLaps;
        }

        return 0;
    }
}