package com.epam.homework;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     * -2  1  2
     *  0 -1  0
     *  1 -2  3
     *
     * Выходные данные:
     * 8
     *
     *
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     *
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        System.out.println(determinant(matrix));
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

    private static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int sum = 0;
        for (int j = 0; j < matrix.length; j++) {
            // "(j + 1)" is put instead of "j" because of j starts from 0
            sum += Math.pow(-1, 1 + (j + 1)) * matrix[0][j] * determinant(minor(matrix, j));
        }

        return sum;
    }

    private static int[][] minor(int[][] matrix, int columnN) {
        int[][] minor = new int[matrix.length - 1][matrix[0].length - 1];

        // remove 0-row and columnN-column
        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < columnN) {
                    minor[i - 1][j] = matrix[i][j];
                }
                if (j > columnN) {
                    minor[i - 1][j - 1] = matrix[i][j];
                }
            }
        }

        return minor;
    }
}
