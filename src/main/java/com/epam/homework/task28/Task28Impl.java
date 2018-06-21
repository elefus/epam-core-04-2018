package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.Set;

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
        int numberOvertaking = 0;
        ArrayList<Car> arrayCars = new ArrayList<>(cars);
        for (int i = 0; i < cars.size(); i++) {
            for (int j = i; j < cars.size(); j++) {
               if (i != j){
                   numberOvertaking += getNumberOvertakingForTwoCars(arrayCars.get(i), arrayCars.get(j), lengthLap, numberLaps);
               }
            }
        }
        return numberOvertaking;
    }

    private static int getNumberOvertakingForTwoCars(Car car1, Car car2, int lengthLap, int numberLaps) {
        int result = 0;
        int distance = lengthLap * numberLaps;
        double timeCar1 = distance / car1.getSpeed();
        double timeCar2 = distance / car2.getSpeed();

        if (car1.getSpeed() > car2.getSpeed()) {
            if (car1.getStartPosition() > car2.getStartPosition()) {
                result++;
            }
            int overtaking = (int) (distance - car2.getSpeed() * timeCar1) / lengthLap;
            result = result + overtaking;
        } else {
            if (car2.getStartPosition() > car1.getStartPosition()) {
                result++;
            }
            int overtaking = (int) (distance - car1.getSpeed() * timeCar2) / lengthLap;
            result = result + overtaking;
        }
        return result;
    }
}
