package com.epam.homework.task27;

import java.util.HashSet;
import java.util.Set;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}

class Graph extends Task27.AbstractGraph {

    private Set<Edge> edges = new HashSet<>();
    Graph(int numberNodes) {
        super(numberNodes);
    }

    @Override
    public void addEdge(int first, int second) {
        edges.add(new Edge(first, second));
    }

    @Override
    public void removeEdge(int first, int second) {
        edges.remove(new Edge(first, second));
    }

    @Override
    public boolean isEdgeExists(int first, int second) {
        return (edges.contains(new Edge(first, second)) || edges.contains(new Edge(second, first)));
    }

    class Edge {
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

        @Override
        public boolean equals(Object edge) {
            if (!edge.getClass().isInstance(this)) {
                return false;
            }
            return (this.first == ((Edge) edge).getFirst()) && (this.second == ((Edge) edge).getSecond());
        }
    }
}
