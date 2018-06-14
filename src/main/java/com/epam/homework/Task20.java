package com.epam.homework;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  1
     *  2
     *  4
     *  2  4 -2 -3
     *  0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int destRow = scanner.nextInt();
        int destColumn = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        Pair<Integer, Integer> rowAndColumnOfMinEl = getRowAndColumnOfMinEl(matrix);
        int[][] reorderedMatrix = reorder(matrix, rowAndColumnOfMinEl.getFirst(), rowAndColumnOfMinEl.getSecond(),
                destRow, destColumn);

        System.out.println(reorderedMatrix.length);
        print(reorderedMatrix);
    }

    private static int[][] reorder(int[][] matrix, int initRow, int initColumn, int destRow, int destColumn) {
        swapRows(matrix, initRow, destRow);
        swapColumn(matrix, initColumn, destColumn);

        return matrix;
    }

    private static void swapRows(int[][] matrix, int initRow, int destRow) {
        int[] tmpRow = matrix[initRow];
        matrix[initRow] = matrix[destRow];
        matrix[destRow] = tmpRow;
    }

    private static void swapColumn(int[][] matrix, int initColumn, int destColumn) {
        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][destColumn];
            matrix[i][destColumn] = matrix[i][initColumn];
            matrix[i][initColumn] = tmp;
        }
    }

    private static Pair<Integer, Integer> getRowAndColumnOfMinEl(int[][] matrix) {
        int rowN = 0;
        int columnN = 0;
        int minEl = matrix[rowN][columnN];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (minEl > matrix[i][j]) {
                    rowN = i;
                    columnN = j;
                    minEl = matrix[rowN][columnN];
                }
            }
        }

        return new Pair<>(rowN, columnN);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int el : row) {
                System.out.printf("%4d", el);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    static class Pair<F, S> {
        private F first;
        private S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }
}
