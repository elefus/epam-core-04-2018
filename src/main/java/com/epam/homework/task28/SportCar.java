package com.epam.homework.task28;

public class SportCar implements Task28.Car {
    private int starPosition;
    private int speed;

    SportCar(int starPosition, int speed) {
        this.starPosition = starPosition;
        this.speed = speed;
    }

    @Override
    public int getStartPosition() {
        return starPosition;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
