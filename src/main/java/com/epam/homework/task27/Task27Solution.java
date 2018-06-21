package com.epam.homework.task27;

import java.util.HashSet;
import java.util.Set;

public class Task27Solution implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new CustomAbstractGraph(numberNodes);
    }

    class CustomAbstractGraph extends AbstractGraph {

        Set<Edge> edges = new HashSet<>();

        CustomAbstractGraph(int numberNodes) {
            super(numberNodes);
        }

        public void print() {
            for (Edge edge : edges) {
                System.out.println(edge.first + " " + edge.second);
            }
        }

        @Override
        public void addEdge(int first, int second) {
            if ((first != second) && (first < NUMBER_NODES) && (second < NUMBER_NODES) && !isEdgeExists(second, first)) {
                edges.add(new Edge(first, second));
            }
        }

        @Override
        public void removeEdge(int first, int second) {
            edges.remove(new Edge(first, second));
            edges.remove(new Edge(second, first));
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return edges.contains(new Edge(first, second)) || edges.contains(new Edge(second, first));
        }
    }

    @Data
    @AllArgsConstructor
    final class Edge {
        int first;
        int second;
    }
}
