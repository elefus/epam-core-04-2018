package com.epam.homework.task28;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Implementation implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        List<Car> carList = new ArrayList<>(cars);
        int numOfOvertaking = 0;
        for (int i = 0; i < carList.size(); i++) {
            for (int j = i + 1; j < carList.size(); j++) {

                if (carList.get(i).getSpeed() >= carList.get(j).getSpeed()) {
                    numOfOvertaking += getNumOfOvertakingForPair(carList.get(i), carList.get(j), lengthLap, numberLaps);
                } else {
                    numOfOvertaking += getNumOfOvertakingForPair(carList.get(j), carList.get(i), lengthLap, numberLaps);
                }
            }

        }
        return numOfOvertaking;

    }

    private int getNumOfOvertakingForPair(Car car1, Car car2, int lengthLap, int numberLaps) {

        int totalRaceLen = lengthLap * numberLaps;
        int numOfOvertakingForPair = (totalRaceLen - car2.getSpeed() * (totalRaceLen / car1.getSpeed())) / lengthLap;

        if (car1.getStartPosition() > car2.getStartPosition()) {
            numOfOvertakingForPair++;
        }

        return numOfOvertakingForPair;
    }
}

