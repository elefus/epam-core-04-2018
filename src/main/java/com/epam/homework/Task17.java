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

        System.out.println(getDeterminant(matrix));
    }

    private static int getDeterminant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[0][i] * Math.pow((-1), 2 + i) * getDeterminant(getMinorOfMatrix(matrix, i));
        }
        return result;
    }

    private static int[][] getMinorOfMatrix(int[][] matrix, int ignoreColumn) {
        int[][] minorOfMatrix = new int[matrix.length - 1][matrix.length - 1];
        for (int j = 0; j < minorOfMatrix.length; j++) {
            System.arraycopy(matrix[j + 1], 0, minorOfMatrix[j], 0, ignoreColumn);
            System.arraycopy(matrix[j + 1], ignoreColumn + 1, minorOfMatrix[j],
                    ignoreColumn, minorOfMatrix.length - ignoreColumn);
        }
        return minorOfMatrix;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}