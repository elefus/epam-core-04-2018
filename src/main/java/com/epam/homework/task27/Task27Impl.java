package com.epam.homework.task27;


public class Task27Impl implements Task27 {
    /**
     * Реализовать класс Graph, представляющий собой неориентированный граф (между двумя вершинами допустимо максимум одно ребро).
     * Методы должны поддерживать быстрое добавление и удаление ребер.
     *
     * @param numberNodes Количество вершин в графе.
     * @return Граф указанной конфигурации.
     */
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

}

class Graph extends Task27.AbstractGraph {
    Graph(int numberNodes) {
        super(numberNodes);
    }

    private byte[][] graph = new byte[NUMBER_NODES][NUMBER_NODES];

    /**
     * Добавление ребра в граф.
     *
     * @param first  Первая связываемая вершина.
     * @param second Вторая связываемая вершина.
     */
    @Override
    public void addEdge(int first, int second) {
        graph[first][second] = 1;
        graph[second][first] = 1;
    }

    /**
     * Удаление ребра из графа.
     *
     * @param first  Первая освобождаемая от связи вершина.
     * @param second Вторая освобождаемая от связи вершина.
     */
    @Override
    public void removeEdge(int first, int second) {
        graph[first][second] = 0;
        graph[second][first] = 0;
    }

    /**
     * Проверка наличия ребра.
     *
     * @param first  Первая вершина.
     * @param second Вторая вершина.
     */
    @Override
    public boolean isEdgeExists(int first, int second) {
        return (graph[first][second] == 1);
    }

}
