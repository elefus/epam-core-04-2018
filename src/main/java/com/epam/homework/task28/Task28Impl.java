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
            for (int j = i + 1; j < carsList.size(); j++) {

                CarImpl fastCar;
                CarImpl slowCar;

                // Сравнение времени, за которое i-я и j-я машины преодолеют свой путь
                if ((raceTrackLength + carsList.get(i).getStartPosition()) / carsList.get(i).getSpeed() <=
                        (raceTrackLength + carsList.get(j).getStartPosition()) / carsList.get(j).getSpeed()) {
                    fastCar = (CarImpl) carsList.get(i);
                    slowCar = (CarImpl) carsList.get(j);
                } else {
                    fastCar = (CarImpl) carsList.get(j);
                    slowCar = (CarImpl) carsList.get(i);
                }

                // Время, в течение которого возможен обгон между парой машин
                double time = fastCar.getTime(raceTrackLength);

                // Количество обгонов между парой машин без учёта начальных положений
                overtakingCount += (raceTrackLength - slowCar.getDistance(time)) / lengthLap;

                // Учёт начального положения
                if (fastCar.startPosition > slowCar.startPosition) {
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

        public double getTime(double distance) {
            return distance / speed;
        }

        public double getDistance(double time) {
            return time * speed;
        }
    }
}
