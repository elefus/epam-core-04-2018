package com.epam.homework.task26;

public class Segment implements Task26.ISegment {
    private Task26.I2DPoint firstPoint;
    private Task26.I2DPoint secondPoint;

    Segment(Task26.I2DPoint firstPoint, Task26.I2DPoint secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public Task26.I2DPoint first() {
        return firstPoint;
    }

    @Override
    public Task26.I2DPoint second() {
        return secondPoint;
    }
}