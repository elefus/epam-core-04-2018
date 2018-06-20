package com.epam.homework;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowAfterSwap = sc.nextInt();
        int columnAfterSwap = sc.nextInt();
        int matrixDimension = sc.nextInt();
        int[][] matrixFromInput = readMatrix(sc, matrixDimension);

        int[] initialPosOfMinElement = findMinimalElementPosition(matrixFromInput);
        int[][] matrixAfterMove =
                moveElementOfMatrixToNewPos(matrixFromInput, initialPosOfMinElement, rowAfterSwap, columnAfterSwap);

        printMatrix(matrixAfterMove);

    }

    private static int[][] moveElementOfMatrixToNewPos(int[][] matrix, int[] initialPos, int rowAfter, int colAfter) {
        int initialRow = initialPos[0];
        int initialColumn = initialPos[1];

        swapRow(matrix, initialRow, rowAfter);
        swapColumn(matrix, initialColumn, colAfter);
        return matrix;
    }

    private static void swapRow(int[][] matrix, int initialRow, int rowAfterSwap) {
        int[] temp = matrix[initialRow];
        matrix[initialRow] = matrix[rowAfterSwap];
        matrix[rowAfterSwap] = temp;
    }

    private static void swapColumn(int[][] matrix, int initialColumn, int columnAfterSwap) {
        for (int[] row : matrix) {
            int temp = row[initialColumn];
            row[initialColumn] = row[columnAfterSwap];
            row[columnAfterSwap] = temp;
        }
    }

    private static int[] findMinimalElementPosition(int[][] matrix) {
        int minElement = matrix[0][0];
        int[] minElementXY = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (minElement > matrix[i][j]) {
                    minElement = matrix[i][j];
                    minElementXY[0] = i;
                    minElementXY[1] = j;
                }
            }
        }

        return minElementXY;
    }

    private static int[][] readMatrix(Scanner scanner, int matrixDimension) {
        int[][] matrix = new int[matrixDimension][matrixDimension];
        for (int row = 0; row < matrixDimension; ++row) {
            for (int column = 0; column < matrixDimension; ++column) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                System.out.print(matrix[row][column] + "    ");
            }
            System.out.println();
        }
    }
}
