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
        System.out.println(matrixDeterminant(matrix));

    }

    public static int matrixDeterminant(int[][] matrix) {
        double[][] doubleMatrix = new double[matrix.length][matrix.length];
        double countDivider = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                doubleMatrix[row][col] = (double) matrix[row][col];
            }
        }
        for (int row = 0; row < matrix.length - 1; row++) {
            if (doubleMatrix[row][row] == 0) {
                int firstNotZeroElement = 0;
                for (int i = row + 1; i < matrix.length; i++) {
                    if (doubleMatrix[i][row] != 0) firstNotZeroElement = i;
                }
                if (firstNotZeroElement == 0) {
                    return 0;
                }
                for (int i = row; i < matrix.length; i++) {
                    doubleMatrix[row][i] = doubleMatrix[row][i] + doubleMatrix[firstNotZeroElement][i];
                }
            }
            countDivider*=doubleMatrix[row][row];
            for (int i = row + 1; i < matrix.length; i++) {
                double firstLineElement = doubleMatrix[i][row];
                for (int col = row; col < matrix.length; col++) {
                    doubleMatrix[i][col] -= firstLineElement * doubleMatrix[row][col] / doubleMatrix[row][row];
                }
            }
        }
        return (int) Math.round(doubleMatrix[matrix.length - 1][matrix.length - 1] * countDivider);
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
