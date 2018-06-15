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
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);

        System.out.println(getMatrixDeterminant(matrix));

    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] getAdditionalMatrix(int[][] matrix, int row, int col){

        int dimension = matrix.length;
        int[][] additionalMatrix = new int[dimension - 1][dimension - 1];
        int offset = 0;
        for (int i = 0; i < dimension; i++){
            if (i == row) {
                offset = 1;
                continue;
            }
            System.arraycopy(matrix[i], 0, additionalMatrix[i - offset], 0, col);
            System.arraycopy(matrix[i], col + 1, additionalMatrix[i - offset], col, dimension - col - 1);
        }
        return additionalMatrix;

    }

    private static int getMatrixDeterminant(int[][] matrix){

        int dimension = matrix.length;
        if (dimension == 1) {
            return matrix[0][0];
        }
        if (dimension == 2) {
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        if (dimension == 3) {
            return matrix[0][0]*matrix[1][1]*matrix[2][2] - matrix[0][0]*matrix[1][2]*matrix[2][1]
                 - matrix[0][1]*matrix[1][0]*matrix[2][2] + matrix[0][1]*matrix[1][2]*matrix[2][0]
                 + matrix[0][2]*matrix[1][0]*matrix[2][1] - matrix[0][2]*matrix[1][1]*matrix[2][0];
        }
        int sumOfMinors = 0;
        for (int j = 0; j < dimension; j++) {
            int sign = j % 2 == 0 ? 1 : -1;
            sumOfMinors += sign*matrix[0][j]*getMatrixDeterminant(getAdditionalMatrix(matrix, 0, j));
        }
        return sumOfMinors;

    }

}
