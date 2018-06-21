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
        Scanner sc = new Scanner(System.in);
        int matrixDimension = sc.nextInt();
        int[][] inputMatrix = readMatrix(sc, matrixDimension);
        
        System.out.println(getMatrixDeterminant(inputMatrix));
    }

    private static int getMatrixDeterminant(int[][] matrix) {
        int matrixDimension = matrix.length;
        int det = 0;

        switch (matrixDimension) {
            case 1:
                return matrix[0][0];
            case 2:
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            default:
                for (int i = 0; i < matrixDimension; i++) {
                    int numFromWorkRow = (i % 2 == 0) ? matrix[0][i] : -matrix[0][i];
                    det += numFromWorkRow * getMatrixDeterminant(getMinorMatrix(matrix, i));
                }
        }
        return det;
    }

    private static int[][] getMinorMatrix(int[][] matrix, int columnInWork) {
        int matrixDimension = matrix.length;
        int[][] minorMatrix = new int[matrixDimension - 1][matrixDimension - 1];

        for (int i = 1; i < matrixDimension; i++) {
            System.arraycopy(matrix[i], 0, minorMatrix[i - 1], 0, columnInWork);
            System.arraycopy(matrix[i], columnInWork + 1,
                    minorMatrix[i - 1], columnInWork, (matrixDimension - 1) - columnInWork);
        }
        return minorMatrix;
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
}



