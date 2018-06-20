package com.epam.homework.task28;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

public class Task28class implements Task28 {

    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        List<MyCar> carsList = new ArrayList<>();
        for (Car car : cars) {
            carsList.add(new MyCar(car.getStartPosition(), car.getSpeed()));
        }
        Collections.sort(carsList);
        for (int i = 0; i < carsList.size() - 1; i++) {
            for (int j = i + 1; j < carsList.size(); j++) {
                numberOvertaking += pairNumberOvertaking(carsList.get(i), carsList.get(j), lengthLap, numberLaps);
            }
        }
        return numberOvertaking;
    }

     private static int pairNumberOvertaking(Car car1, Car car2, int lengthLap, int numberLaps) {
        int pairNumberOvertaking = 0;
        int fastestTime = lengthLap * numberLaps / car1.getSpeed();
        int difference = lengthLap * numberLaps - car2.getSpeed() * fastestTime;
        pairNumberOvertaking += Math.abs(difference / lengthLap);
         if ((car1.getStartPosition() > car2.getStartPosition()) && (car2.getSpeed() < car1.getSpeed())) {
             pairNumberOvertaking += 1;
         }
        return pairNumberOvertaking;
    }

    @Data
    @AllArgsConstructor
    static class MyCar implements Car, Comparable<MyCar> {
        int startPosition;
        int speed;

        @Override
        public int compareTo(MyCar o) {
            return o.speed - speed;
        }
    }
}

