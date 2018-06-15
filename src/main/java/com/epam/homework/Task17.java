package com.epam.homework;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int matrixSize = Integer.parseInt(in.nextLine());
            int[][] matrix = readMatrix(in, matrixSize);
            System.out.println(getDeterminant(matrix));
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int getDeterminant(int[][] matrix) {

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int sum = 0;

        for (int j = 0; j < matrix.length; j++) {

            int sign = (j % 2 == 0) ? 1 : -1;
            sum += sign * matrix[0][j] * getDeterminant(getMinor(matrix, 0, j));
        }

        return sum;
    }

    private static int[][] getMinor(int[][] matrix, int rowToRemove, int columnToRemove) {

        int[][] minor = new int[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor.length; j++) {

                // Indices for Matrix
                int iInMatrix = (i >= rowToRemove) ? i + 1 : i;
                int jInMatrix = (j >= columnToRemove) ? j + 1 : j;

                minor[i][j] = matrix[iInMatrix][jInMatrix];
            }
        }

        return minor;
    }
}
