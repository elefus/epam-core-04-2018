package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Solution implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        List<Car> allCars = new ArrayList<>(cars);
        int numOfOvertaking = 0;
        int totalLengthOfRace = lengthLap * numberLaps;

        for (int i = 0; i < allCars.size(); i++) {
            Car car1 = allCars.get(i);
            for (int j = i + 1; j < allCars.size(); j++) {
                Car car2 = allCars.get(j);

                if (car1.getSpeed() > car2.getSpeed()) {
                    Car temp;
                    temp = car1;
                    car1 = car2;
                    car2 = temp;
                }
                numOfOvertaking += (int)(totalLengthOfRace - (car1.getSpeed()) * (totalLengthOfRace / car2.getSpeed()) / lengthLap);
            }
        }
        return numOfOvertaking;
    }
}

