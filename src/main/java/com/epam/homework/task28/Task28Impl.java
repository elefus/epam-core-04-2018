package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int overallLength = lengthLap * numberLaps;
        int numberOfOvertakes = 0;
        List<Car> carList = new ArrayList<>(cars);

        for (int i = 0; i < carList.size(); i++) {
            Car currCar = carList.get(i);
            int currCarPosition = currCar.getStartPosition();
            int currCarSpeed = currCar.getSpeed();
            int raceTimeCurrCar = overallLength / currCarSpeed;

            for (int j = i + 1; j < carList.size(); j++) {
                Car nextCar = carList.get(j);
                int nextCarPosition = nextCar.getStartPosition();
                int nextCarSpeed = nextCar.getSpeed();
                int raceTimeNextCar = overallLength / nextCarSpeed;

                int slowerCarSpeed = Math.min(currCarSpeed, nextCarSpeed) * Math.min(raceTimeCurrCar, raceTimeNextCar);

                numberOfOvertakes += (overallLength - slowerCarSpeed) / lengthLap;

                if ((currCarPosition < nextCarPosition) && (nextCarSpeed > currCarSpeed)
                        || (currCarPosition > nextCarPosition) && (nextCarSpeed < currCarSpeed)) {
                    numberOfOvertakes++;
                }
            }
        }
        return numberOfOvertakes;
    }
}
