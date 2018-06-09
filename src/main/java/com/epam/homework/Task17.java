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

    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int calculateMatrixDeterminant(int[][] matrix) {
        int dimension = matrix.length;

        if(dimension == 1) {
            return matrix[0][0];
        }

        if (dimension == 2) {
            return matrix[0][0] * matrix [1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < dimension; i++) {
            int element = (i % 2 == 0) ? matrix[0][i] : - matrix[0][i];
            determinant += element * calculateMatrixDeterminant(getSubmatrix(matrix, i));
        }

        return determinant;
    }

    private static int[][] getSubmatrix(int[][] matrix, int minorColumn) {
        int dimension = matrix.length;
        int[][] submatrix = new int[dimension - 1][dimension - 1];

        for (int i = 1; i < dimension; i++) {
            System.arraycopy(matrix[i], 0, submatrix[i - 1], 0, minorColumn);
            System.arraycopy(matrix[i], minorColumn + 1, submatrix[i - 1], minorColumn, (dimension - 1) - minorColumn);
        }

        return submatrix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readMatrix(in);
        System.out.println(calculateMatrixDeterminant(matrix));
    }
}
