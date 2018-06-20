package com.epam.homework.task27;

public class Graph extends Task27.AbstractGraph {

    private int[][] edgesMatrix;

    Graph(int numberNodes) {
        super(numberNodes);

        edgesMatrix = new int[NUMBER_NODES][NUMBER_NODES];
    }

    @Override
    public void addEdge(int first, int second) {
        if (first >=0 && first <= NUMBER_NODES && second >= 0 && second <= NUMBER_NODES) {
            edgesMatrix[first][second] = 1;
        }
    }

    @Override
    public void removeEdge(int first, int second) {
        if (first >=0 && first <= NUMBER_NODES && second >= 0 && second <= NUMBER_NODES) {
            edgesMatrix[first][second] = 0;
        }
    }

    @Override
    public boolean isEdgeExists(int first, int second) {
        return (first >= 0 && first <= NUMBER_NODES && second >= 0 && second <= NUMBER_NODES)
                && edgesMatrix[first][second] == 1;
    }
}
