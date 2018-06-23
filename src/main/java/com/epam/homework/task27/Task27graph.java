package com.epam.homework.task27;

public class Task27graph implements Task27 {

    @Override
    public AbstractGraph createGraph(int nodesNumber) {
        return new AbstractGraph(nodesNumber) {

            private int[][] grMatrix = new int[nodesNumber][nodesNumber];

            @Override
            public void addEdge(int first, int second) {
                grMatrix[first][second] = 1;
                grMatrix[second][first] = 1;
            }

            @Override
            public void removeEdge(int first, int second) {
                grMatrix[first][second] = 0;
                grMatrix[second][first] = 0;
            }

            @Override
            public boolean isEdgeExists(int first, int second) {
                return Integer.compare(grMatrix[first][second], 1) == 0;
            }
        };
    }
}