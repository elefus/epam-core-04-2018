package com.epam.homework.task27;

public class Task27Imlp implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    public class Graph extends AbstractGraph {

        private int[][] matrix;

        private Graph(int numberNodes) {
            super(numberNodes);
            matrix = new int[NUMBER_NODES][NUMBER_NODES];

        }

        @Override
        public void addEdge(int first, int second) {
            matrix[first][second] = 1;

        }

        @Override
        public void removeEdge(int first, int second) {
            matrix[first][second] = 0;

        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return matrix[first][second] == 1;
        }
    }
}