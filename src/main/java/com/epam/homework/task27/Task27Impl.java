package com.epam.homework.task27;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task27Impl implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

}

class Graph extends Task27.AbstractGraph {

    protected final int NUMBER_NODES;

    private Set<Edge> edges;

    public Graph(int numberNodes) {

        super(numberNodes);
        this.NUMBER_NODES = numberNodes;
        edges = new HashSet<>();

    }

    public static class Edge {

        private int first;
        private int second;

        Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }

        int getFirst() {
            return first;
        }

        int getSecond() {
            return second;
        }

    }

    @Override
    public void addEdge(int first, int second) {

        edges.add(new Edge(first, second));

    }

    @Override
    public void removeEdge(int first, int second) {

        edges.removeIf(edge -> edge.getFirst() == first && edge.getSecond() == second || edge.getFirst() == second && edge.getSecond() == first);

    }

    @Override
    public boolean isEdgeExists(int first, int second) {

        for (Edge edge : edges) {
            if (edge.getFirst() == first && edge.getSecond() == second || edge.getFirst() == second && edge.getSecond() == first) {
                return true;
            }
        }
        return false;

    }
}
