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

    private static int dimension;
    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        dimension = scanner.nextInt();
        matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrixToPrint) {
        System.out.println(dimension);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.printf("%12d", matrixToPrint[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static int[] findPositionOfMinElementInMatrix(int[][] matrix) {
        int minElement = matrix[0][0];
        int[] rowAndColumnOfMinElement = new int[2];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    rowAndColumnOfMinElement[0] = i;
                    rowAndColumnOfMinElement[1] = j;
                }
            }
        }

        return rowAndColumnOfMinElement;
    }

    private static int[][] moveMinElementToPosition(int srcRow, int srcColumn, int destRow, int destColumn) {
        int[][] matrixWithExchangedColsAndRows = new int[dimension][dimension];
        System.arraycopy(matrix, 0, matrixWithExchangedColsAndRows, 0, dimension);

        System.arraycopy(matrix, srcRow, matrixWithExchangedColsAndRows, destRow, 1);
        System.arraycopy(matrix, destRow, matrixWithExchangedColsAndRows, srcRow, 1);

        int temp;
        for (int i = 0; i < dimension; i++) {
            temp = matrixWithExchangedColsAndRows[i][srcColumn];
            matrixWithExchangedColsAndRows[i][srcColumn] = matrixWithExchangedColsAndRows[i][destColumn];
            matrixWithExchangedColsAndRows[i][destColumn] = temp;

        }

        return matrixWithExchangedColsAndRows;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] destPosition = new int[2];
        destPosition[0] = in.nextInt();
        destPosition[1] = in.nextInt();
        readMatrix(in);
        int[] srcPos = findPositionOfMinElementInMatrix(matrix);
        matrix = moveMinElementToPosition(srcPos[0], srcPos[1], destPosition[0], destPosition[1]);
        printMatrix(matrix);
    }
}
