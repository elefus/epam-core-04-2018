package com.epam.homework.task27;

import java.util.*;

public class Task27Impl implements Task27 {

    /**
     * Реализовать класс Graph, представляющий собой неориентированный граф (между двумя вершинами допустимо максимум одно ребро).
     * Методы должны поддерживать быстрое добавление и удаление ребер.
     * @param numberNodes Количество вершин в графе.
     * @return Граф указанной конфигурации.
     */
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}

class Graph extends Task27.AbstractGraph {

    private Node[] graph;

    public Graph(int numberNodes) {
        super(numberNodes);
        graph = new Node[NUMBER_NODES];
        for (int i = 0; i < NUMBER_NODES; i++) {
            graph[i] = new Node();
        }
    }

    /**
     * Добавление ребра в граф.
     *
     * @param first  Первая связываемая вершина.
     * @param second Вторая связываемая вершина.
     */
    @Override
    public void addEdge(int first, int second) {
        graph[first].relatedNodes.add(graph[second]);
        graph[second].relatedNodes.add(graph[first]);
    }

    /**
     * Удаление ребра из графа.
     * @param first Первая освобождаемая от связи вершина.
     * @param second Вторая освобождаемая от связи вершина.
     */
    @Override
    public void removeEdge(int first, int second) {
        graph[first].relatedNodes.remove(graph[second]);
        graph[second].relatedNodes.remove(graph[first]);

    }

    /**
     * Проверка наличия ребра.
     * @param first Первая вершина.
     * @param second Вторая вершина.
     */
    @Override
    public boolean isEdgeExists(int first, int second) {
        return graph[first].relatedNodes.contains(graph[second]);
    }

    private class Node {

        private List<Node> relatedNodes;

        private Node() {
            relatedNodes = new LinkedList<>();
        }
    }
}
