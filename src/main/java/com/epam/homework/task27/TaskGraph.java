package com.epam.homework.task27;

public class TaskGraph implements Task27 {
    @Override
    public AbstractGraph createGraph(int nodesNumber) {
        return new Graph(nodesNumber);
    }

    public class Graph extends AbstractGraph {

        private int[][] graphMatrix;

        public Graph(int numberNodes) {
            super(numberNodes);
            graphMatrix = new int[NUMBER_NODES][NUMBER_NODES];

        }

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
            return graphMatrix[first][second] == 1;
        }
    }
}
