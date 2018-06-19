package com.epam.homework.task27;

import java.util.*;

public class Task27Implementation implements Task27 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new AbstractGraph(numberNodes) {

            private List<List<Integer>> graph = new ArrayList<>();

            @Override
            public void addEdge(int first, int second) {
                graph.get(first).add(second);
                graph.get(second).add(first);
            }

            @Override
            public void removeEdge(int first, int second) {
                graph.get(first).remove(second);
                graph.get(second).remove(first);
            }

            @Override
            public boolean isEdgeExists(int first, int second) {
                return Integer.compare(graph.get(first).get(second),second) == 0;
            }
        };
    }
}
