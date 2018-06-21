package com.epam.homework.task27;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}
class Graph extends Task27.AbstractGraph {

    private boolean[][] edgesArr;

    public Graph(int numberNodes) {
        super(numberNodes);
        edgesArr = new boolean[numberNodes][numberNodes];
    }

    @Override
    public void addEdge(int first, int second) {
        edgesArr[first][second] = true;
        edgesArr[second][first] = true;
    }

    @Override
    public void removeEdge(int first, int second) {
        edgesArr[first][second] = false;
        edgesArr[second][first] = false;
    }

    @Override
    public boolean isEdgeExists(int first, int second) {
        return edgesArr[first][second];
    }
}
