package com.epam.homework.task28;

import java.util.*;

public class Task28Impl implements Task28 {
    public int getNumberOvertaking(Set<Task28.Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        int lengthOfRace = lengthLap * numberLaps;

        List<Task28.Car> carList = new ArrayList<>(cars);
        Collections.sort(carList, Comparator.comparing(Task28.Car::getSpeed));
        Collections.reverse(carList);

        for (int i = 0; i < carList.size(); i++) {
            Task28.Car firstCar = carList.get(i);
            int speedOfTheFirstCar = firstCar.getSpeed();
            int startPositionOfTheFirstCar = firstCar.getStartPosition();

            for (int j = i + 1; j < carList.size(); j++) {
                Task28.Car secondCar = carList.get(j);
                int speedOfTheSecondCar = secondCar.getSpeed();
                int startPositionOfTheSecondCar = secondCar.getStartPosition();
                if (speedOfTheFirstCar == speedOfTheSecondCar) {
                    continue;
                }

                double difference = startPositionOfTheSecondCar - startPositionOfTheFirstCar;
                if (startPositionOfTheSecondCar < startPositionOfTheFirstCar) {
                    difference = lengthLap + difference;
                }

                double timeSecond = (double) (lengthOfRace + startPositionOfTheFirstCar) / speedOfTheFirstCar;
                numberOvertaking = (int) Math.floor(1 + (timeSecond * (speedOfTheFirstCar - speedOfTheSecondCar) - difference) / lengthLap);
            }
            numberOvertaking += numberOvertaking;
        }
        return numberOvertaking;
    }
}
