package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28{

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        List<Car> carsL = new ArrayList<>(cars);
        int sumOfOvertaking = 0;
        int raceLength = lengthLap * numberLaps;

        for (int i = 0; i < carsL.size(); i++) {
            Car car1 = carsL.get(i);
            for (int j = i + 1; j < carsL.size(); j++) {
                Car car2 = carsL.get(j);

                if (car1.getSpeed() > car2.getSpeed()) {
                    Car temp;
                    temp = car1;
                    car1 = car2;
                    car2 = temp;
                }
                sumOfOvertaking += (int) (raceLength - (car1.getSpeed()) * (raceLength/car2.getSpeed()) / lengthLap);

            }
        }
        return sumOfOvertaking;
    }
}
