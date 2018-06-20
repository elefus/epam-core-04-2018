package com.epam.homework.task27;

public class Task27Impl implements Task27{

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return null;
    }

    public class AbstractGrapImpl extends AbstractGraph {

        boolean[][] matrix;

        public AbstractGrapImpl(int numberNodes) {
            super(numberNodes);
            matrix = new boolean[numberNodes][numberNodes];
        }

        @Override
        public void addEdge(int first, int second) {
            matrix[second][first] = true;
            matrix[first][second] = true;
        }

        @Override
        public void removeEdge(int first, int second) {
            matrix[second][first] = false;
            matrix[first][second] = false;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return !matrix[second][first] && !matrix[first][second];
        }
    }

}
