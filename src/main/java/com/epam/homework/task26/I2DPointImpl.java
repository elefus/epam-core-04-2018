package com.epam.homework.task26;

public class I2DPointImpl implements Task26.I2DPoint {
    private double x;
    private double y;

    I2DPointImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }


}
