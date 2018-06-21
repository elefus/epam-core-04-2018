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
            Car firstCar = allCars.get(i);
            int timeFirst = totalLengthOfRace / firstCar.getSpeed();
            for (int j = i + 1; j < allCars.size(); j++) {
                Car secondCar = allCars.get(j);

                int timeSecond = totalLengthOfRace / secondCar.getSpeed();

                int diffBetweenCars = (totalLengthOfRace - Math.min(firstCar.getSpeed(), secondCar.getSpeed()) * Math.min(timeFirst, timeSecond));

                numOfOvertaking += Math.abs(diffBetweenCars / lengthLap);

                if ((firstCar.getStartPosition() < secondCar.getStartPosition()) && (secondCar.getSpeed() > firstCar.getSpeed())) {
                    numOfOvertaking++;
                }
                if ((firstCar.getStartPosition() > secondCar.getStartPosition()) && (secondCar.getSpeed() < firstCar.getSpeed())) {
                    numOfOvertaking++;
                }
            }
        }
        return numOfOvertaking;
    }
}

