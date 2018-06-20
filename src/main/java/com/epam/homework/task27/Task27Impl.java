package com.epam.homework.task27;

public class Task27Impl implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    class Graph extends AbstractGraph {

        byte[][] matrix;

        public Graph(int numberNodes) {
            super(numberNodes);
            matrix = new byte[numberNodes][numberNodes];
            for (int i = 0; i < numberNodes; i++) {
                for (int j = 0; j < numberNodes; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        @Override
        public void addEdge(int first, int second) {
            matrix[second][first] = 1;
            matrix[first][second] = 1;
        }

        @Override
        public void removeEdge(int first, int second) {
            matrix[second][first] = 0;
            matrix[first][second] = 0;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            if (matrix[second][first] == 0 && matrix[first][second] == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
