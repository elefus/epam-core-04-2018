package com.epam.homework.task27;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}
