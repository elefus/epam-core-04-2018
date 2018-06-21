package com.epam.homework.task27;

public class Task27Impl implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    public class Graph extends AbstractGraph {
        int[][] adjacencyMatrix;

        public Graph(int numberNodes) {
            super(numberNodes);
            adjacencyMatrix = new int[numberNodes][numberNodes];
        }

        @Override
        public void addEdge(int first, int second) {
            adjacencyMatrix[first][second] = 1;
            adjacencyMatrix[second][first] = 1;
        }

        @Override
        public void removeEdge(int first, int second) {
            adjacencyMatrix[first][second] = 0;
            adjacencyMatrix[second][first] = 0;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return adjacencyMatrix[first][second] == 1;
        }
    }
}