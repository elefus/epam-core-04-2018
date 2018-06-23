package com.epam.homework.task27;

public class Task27Solution implements Task27 {

    @Override
    public AbstractGraph createGraph(int nodesNumber) {
        return new AbstractGraph(nodesNumber) {

            private int[][] graphMatrix = new int[nodesNumber][nodesNumber];

            @Override
            public void addEdge(int first, int second) {
                graphMatrix[first][second] = 1;
                graphMatrix[second][first] = 1;
            }

            @Override
            public void removeEdge(int first, int second) {
                graphMatrix[first][second] = 0;
                graphMatrix[second][first] = 0;
            }

            @Override
            public boolean isEdgeExists(int first, int second) {
                return Integer.compare(graphMatrix[first][second], 1) == 0;
            }
        };
    }
}
