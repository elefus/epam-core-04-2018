package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        List<Car> carsL = new ArrayList<>(cars);
        int numOfOvertakes = 0;

        for (Car car1 : carsL) {

            int raceLength = lengthLap * numberLaps;
            double timeCar1 = raceLength / car1.getSpeed();

            for (Car car2 : carsL) {
                double timeCar2 = raceLength / car1.getSpeed();
                numOfOvertakes += (int)(raceLength - (Math.min(car1.getSpeed(), car2.getSpeed()) * (Math.min(timeCar1, timeCar2)))) / lengthLap;

                if(car1.getStartPosition() < car2.getStartPosition() && car1.getSpeed() > car2.getSpeed()
                        || car1.getStartPosition() > car2.getStartPosition() && car1.getSpeed() < car2.getSpeed()){
                    numOfOvertakes++;
                }

            }

        }

        return numOfOvertakes;
    }
}
