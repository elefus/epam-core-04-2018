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
        double[][] matrix = readMatrix(scanner);

        System.out.println(methodGauss(matrix));
    }


    private static double[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        double[][] matrix = new double[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextDouble();
            }
        }
        return matrix;
    }


    private static int methodGauss(double[][] matrix) {
        int result = 1;
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            if (matrix[i][i] == 0) {
                int k = i;
                for (int j = i + 1; j < length; j++) {
                    if (matrix[j][i] != 0) {
                        k = j;
                        break;
                    }
                }
                if (i != k) {
                    result = -result;
                    double[] b = matrix[i];
                    matrix[i] = matrix[k];
                    matrix[k] = b;
                } else {
                    return 0;
                }
            }

            double delitel = matrix[i][i];
            result *= delitel;
            for (int j = length - 1; j >= i; j--) {
                matrix[i][j] /= delitel;
            }

            for (int j = i + 1; j < length; j++) {
                delitel = matrix[j][i];
                for (int k = length - 1; k >= i; k--)
                    matrix[j][k] -= delitel * matrix[i][k];
            }
        }
        return result;
    }
}

