package com.epam.homework;

import java.util.Scanner;

import static java.lang.Math.pow;

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
        int matrixDeterminant = calculateMatrixDeterminant(matrix);
        System.out.println(matrixDeterminant);
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

    private static int calculateMatrixDeterminant(int[][] matrix){
        int determinant = 0;
        switch (matrix.length){
            case 1:
                return matrix[0][0];
            case 2:
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            default:
                for (int i = 0; i < matrix.length; i++) {
                    determinant += pow(-1, i) * matrix[0][i] * calculateMatrixDeterminant(calculateMatrixMinor(matrix, i));
                }
                return determinant;
        }
    }

    private static int[][] calculateMatrixMinor(int[][] matrix, int row){
        int[][] matrixMinor = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++)
                if (row <= j) {
                    matrixMinor[i][j] = matrix[i + 1][j + 1];
                } else {
                    matrixMinor[i][j] = matrix[i + 1][j];
                }
        }
        return matrixMinor;
    }
}
