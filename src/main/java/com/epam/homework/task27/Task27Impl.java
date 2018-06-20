package com.epam.homework.task27;

public class Task27Impl implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new AbstractGraph(numberNodes) {

            private int matrix[][] = new int[numberNodes][numberNodes];

            @Override
            public void addEdge(int first, int second) {
                matrix[first][second] = 1;
                matrix[second][first] = 1;
            }

            @Override
            public void removeEdge(int first, int second) {
                matrix[first][second] = 0;
                matrix[second][first] = 0;
            }

            @Override
            public boolean isEdgeExists(int first, int second) {
                return matrix[first][second] == 1;
            }
        };
    }
}
