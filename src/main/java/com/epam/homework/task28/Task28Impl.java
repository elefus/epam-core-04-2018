package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28 {
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {
        int overallLength = lengthLap * numberLaps;
        int numberOvertaking = 0;
        List<Car> carList = new ArrayList<>(cars);

        for (int i = 0; i < carList.size(); i++) {
            int speedCurrCar = carList.get(i).getSpeed();
            int positionCurrCar = carList.get(i).getStartPosition();
            int lapTimeCurrCar = (overallLength + positionCurrCar - 1) / speedCurrCar;

            for (int j = i + 1; j < carList.size(); j++) {
                int speedNextCar = carList.get(j).getSpeed();
                int positionNextCar = carList.get(j).getStartPosition();
                int lapTimeNextCar = (overallLength + positionNextCar - 1) / speedNextCar;

                int possibleOvertakes = Math.max(lapTimeCurrCar, lapTimeNextCar) / Math.min(lapTimeCurrCar,
                        lapTimeNextCar);
                numberOvertaking += possibleOvertakes;
            }
        }
        return numberOvertaking;
    }
}
