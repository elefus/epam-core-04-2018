package com.epam.homework.task28;

import lombok.Data;
import java.util.*;

public class Task28class implements Task28 {
    public static void main(String[] args) {
        Task28class o = new Task28class();
        Set<Car> ass = new HashSet<>();
        MyCar car1 = new MyCar();
        car1.setSpeed(1);
        car1.setStartPosition(1);
        MyCar car2 = new MyCar();
        car2.setSpeed(2);
        car2.setStartPosition(2);
        MyCar car3 = new MyCar();
        car3.setSpeed(3);
        car3.setStartPosition(3);
        ass.add(car1);
        ass.add(car2);
        ass.add(car3);
        System.out.println(ass);
        System.out.println(o.getNumberOvertaking(ass, 4, 1));

    }

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

     private static int pairNumberOvertaking(Car car1, Car car2, int lengthLap, int numberLaps) {
        int pairNumberOvertaking = 0;
        int fastestTime = lengthLap * numberLaps / car1.getSpeed();
        int difference = lengthLap * numberLaps - car2.getSpeed() * fastestTime;
        pairNumberOvertaking += Math.abs(difference / lengthLap);
         if ((car1.getStartPosition() > car2.getStartPosition())) {
             pairNumberOvertaking += 1;
         }
        return pairNumberOvertaking;
    }

    @Data
    static class MyCar implements Car, Comparable<MyCar> {
        int startPosition;
        int speed;

        @Override
        public int compareTo(MyCar o) {
            return o.speed - speed;
        }
    }
}

