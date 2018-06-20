package com.epam.homework.task28;

import java.util.*;

public class Task28Impl implements Task28 {
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        int lengthOfRace = lengthLap * numberLaps;

        List<Car> carList = new ArrayList<>(cars);
        Collections.sort(carList, Comparator.comparing(Car::getSpeed));
        Collections.reverse(carList);

        for (int i = 0; i < carList.size(); i++) {
            Car firstCar = carList.get(i);
            int speedOfTheFirstCar = firstCar.getSpeed();
            int startPositionOfTheFirstCar = firstCar.getStartPosition();

            for (int j = i + 1; j < carList.size(); j++) {
                Car secondCar = carList.get(j);
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

    public class SportCar implements Car {
        private int startPosition;
        private int speed;

        public SportCar(int startPosition, int speed) {
            this.startPosition = startPosition;
            this.speed = speed;
        }

        @Override
        public int getStartPosition() {
            return startPosition;
        }

        @Override
        public int getSpeed() {
            return speed;
        }
    }
}