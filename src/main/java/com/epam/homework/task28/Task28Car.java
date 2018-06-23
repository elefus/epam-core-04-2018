package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Car implements Task28 {

    @Override

    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int outrunnings = 0;
        int lengthOfRace = lengthLap * numberLaps;
        List<Car> list = new ArrayList<>(cars);
        for (int i = 0; i < list.size(); i++) {
            Car firstCar = list.get(i);
            int speedOfTheFirstCar = firstCar.getSpeed();
            int firstCarStart = firstCar.getStartPosition();
            int timeOfTheFirstCar = lengthOfRace / speedOfTheFirstCar;
            for (int j = i + 1; j < list.size(); j++) {
                Car secondCar = list.get(j);
                int speedOfTheSecondCar = secondCar.getSpeed();
                int secondCarStart = secondCar.getStartPosition();
                int timeOfTheSecondCar = lengthOfRace / speedOfTheSecondCar;
                int difference = (lengthOfRace - Math.min(speedOfTheFirstCar, speedOfTheSecondCar) * Math.min(timeOfTheFirstCar, timeOfTheSecondCar));
                outrunnings += Math.abs(difference / lengthLap);
                if ((firstCarStart < secondCarStart) && (speedOfTheSecondCar > speedOfTheFirstCar)) {
                    outrunnings++;
                }
                if ((firstCarStart > secondCarStart) && (speedOfTheSecondCar < speedOfTheFirstCar)) {
                    outrunnings++;
                }
            }
        }
        return outrunnings;
    }
}