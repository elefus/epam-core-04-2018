package com.epam.homework.task28;

import lombok.Data;

import java.util.*;

public class Task28class implements Task28 {

     @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int numberOvertaking = 0;
        List<MyCar> carsList = new ArrayList<>();
        for (Car car : cars) {
            carsList.add((MyCar) car);
        }
        Collections.sort(carsList);
        for (int i = 0; i < carsList.size() - 1; i++) {
            for (int j = i + 1; j < carsList.size(); j++) {
                numberOvertaking += pairNumberOvertaking(carsList.get(i), carsList.get(j), lengthLap, numberLaps);
            }
        }
        return numberOvertaking;
    }

    public static int pairNumberOvertaking(Car car1, Car car2, int lengthLap, int numberLaps) {
        int pairNumberOvertaking = 0;
        double l1 = car1.getStartPosition() < car2.getStartPosition() ? 0.0000000001 : 0;
        double l2 = 0;
        if (l1 == 0) {
            l2 = 0.0000000001;
            pairNumberOvertaking++;
        }
        for (int i = 0; i < numberLaps; i++) {
            l1 += lengthLap;
            l2 += (double) lengthLap / (double) car1.getSpeed() * (double) car2.getSpeed();
            if ((l1 - lengthLap) > l2) {
                l1 -= lengthLap;
                pairNumberOvertaking++;
            }
        }
        return pairNumberOvertaking;
    }

    @Data
    static class MyCar implements Car, Comparable<MyCar> {
        int startPosition;
        int speed;

        @Override
        public int compareTo(MyCar o) {
            return o.speed - speed ;
        }
    }
}

