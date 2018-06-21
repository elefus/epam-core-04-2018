package com.epam.homework.task28;

import java.util.*;

public class Task28Implementation implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lapLength, int lapsCount) {
        List<Car> list = new ArrayList<>(cars);

        int distance = lapLength * lapsCount;

        int counter = 0;

        for (int i = 0; i < list.size(); i++) {
            Car firstCar = list.get(i);
            int timeFirst = distance / firstCar.getSpeed();
            for (int j = i + 1; j < list.size(); j++) {
                Car secondCar = list.get(j);

                int timeSecond = distance / secondCar.getSpeed();

                int diffBetweenCars = (distance - Math.min(firstCar.getSpeed(), secondCar.getSpeed()) * Math.min(timeFirst, timeSecond));

                counter += Math.abs(diffBetweenCars / lapLength);

                if ((firstCar.getStartPosition() < secondCar.getStartPosition()) && (secondCar.getSpeed() > firstCar.getSpeed())) {
                    counter++;
                }
                if ((firstCar.getStartPosition() > secondCar.getStartPosition()) && (secondCar.getSpeed() < firstCar.getSpeed())) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
