package com.epam.homework.task28;

import java.util.*;

public class Task28Impl implements Task28 {

    /**
     * На кольцевой гоночной трассе стоит N автомобилей.
     * Для каждого из них известны начальное положение и скорость.
     * Определить, сколько произойдет обгонов за указанное количество кругов.
     *
     * @param cars       Расположенные на трассе машины.
     * @param lengthLap  Длина одного круга.
     * @param numberLaps Количество кругов.
     * @return Количество осуществленных обгонов.
     */
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        int raceTrackLength = lengthLap * numberLaps;
        int overtakingCount = 0;
        List<Car> carsList = new ArrayList<>(cars);

        for (int i = 0; i < carsList.size(); i++) {

            CarImpl car1 = (CarImpl) carsList.get(i);
            
            for (int j = i + 1; j < carsList.size(); j++) {

                CarImpl car2 = (CarImpl) carsList.get(j);

                // Время, в течение которого возможен обгон между парой машин
                int availableTime = Math.min(car1.getTime(raceTrackLength), car2.getTime(raceTrackLength));

                // Расстояние, которое успеет проехать за это время более медленная машина
                int minDistance = Math.min(car1.getSpeed(), car2.getSpeed()) * availableTime;

                // Количество обгонов между парой машин без учёта начальных положений
                overtakingCount += (raceTrackLength - minDistance) / lengthLap;

                // Учёт начального положения
                if (car1.getStartPosition() > car2.getStartPosition() && car1.getSpeed() > car2.getSpeed()) {
                    overtakingCount++;
                }

                if (car1.getStartPosition() < car2.getStartPosition() && car1.getSpeed() < car2.getSpeed()) {
                    overtakingCount++;
                }
            }
        }
        return overtakingCount;
    }

    /**
     * Машина.
     */
    static class CarImpl implements Car {

        private int startPosition;
        private int speed;

        public CarImpl(int startPosition, int speed) {
            this.startPosition = startPosition;
            this.speed = speed;
        }

        /**
         * Расположение машин в на старте:
         * <p>
         * -----
         * START
         * -----
         * 1
         * 2
         * 3
         * 4
         * 5
         * .
         * .
         * .
         *
         * @return Позиция в начальный момент времени.
         */
        @Override
        public int getStartPosition() {
            return startPosition;
        }

        /**
         * @return Скорость движения.
         */
        @Override
        public int getSpeed() {
            return speed;
        }

        public int getTime(int distance) {
            return distance / speed;
        }
    }
}
