package com.epam.homework.task27;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}

class Graph extends Task27.AbstractGraph {

    private int[][] edgesMatrix;

    Graph(int numberNodes) {
        super(numberNodes);
        edgesMatrix = new int[NUMBER_NODES][NUMBER_NODES];
    }

    @Override
    public void addEdge(int first, int second) {
        edgesMatrix[first][second] = 1;
    }

    @Override
    public void removeEdge(int first, int second) {
        edgesMatrix[first][second] = 0;
    }

    @Override
    public boolean isEdgeExists(int first, int second) {
        return edgesMatrix[first][second] == 1;
    }
}