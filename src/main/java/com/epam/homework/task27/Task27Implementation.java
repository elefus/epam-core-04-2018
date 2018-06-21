package com.epam.homework.task27;

public class Task27Implementation implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    class Graph extends AbstractGraph {

        private int[][] vertexMatrix;

        Graph(int numberNodes) {
            super(numberNodes);
            vertexMatrix = new int[numberNodes][numberNodes];
        }

        @Override
        public void addEdge(int first, int second) {
            vertexMatrix[first][second] = 1;
            vertexMatrix[second][first] = 1;
        }

        @Override
        public void removeEdge(int first, int second) {
            vertexMatrix[first][second] = 0;
            vertexMatrix[second][first] = 0;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return vertexMatrix[first][second] == 1;
        }
    }
}

