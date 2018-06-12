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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        System.out.println(determinant(matrix));
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int determinant(int[][] matrix) {
        int dimension = matrix.length;
        switch (dimension) {
            case 1:
                return matrix[0][0];
            case 2:
                return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
            default:
                int determinant = 0;
                int sign = 1;
                for (int i = 0; i < dimension; i++) {
                    determinant += sign * matrix[0][i] * determinant(minor(matrix, 0, i));
                    sign *= -1;
                }
                return determinant;
        }
    }

    private static int[][] minor(int[][] matrix, int row, int column) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            boolean isRowDeleted = row < i;
            int resultRowIndex = isRowDeleted ? i - 1 : i;

            for (int j = 0; j < matrix[i].length; j++) {
                boolean isColDeleted = column < j;
                int resultColIndex = isColDeleted ? j - 1 : j;

                if (row != i && column != j)
                    minor[resultRowIndex][resultColIndex] = matrix[i][j];
            }
        }
        return minor;
    }
}
