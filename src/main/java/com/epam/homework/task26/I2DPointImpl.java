package com.epam.homework.task26;

public class I2DPointImpl implements Task26.I2DPoint {
    private double x;
    private double y;

    @Override
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
