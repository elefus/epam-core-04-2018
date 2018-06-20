package com.epam.homework.task28;

public class SportCar implements Task28.Car {
    int startPosition;
    int speed;

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
