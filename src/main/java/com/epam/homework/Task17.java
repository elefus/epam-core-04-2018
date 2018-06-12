package com.epam.homework;


import java.util.*;

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
     3
     -2  1  2
     0 -1  0
     1 -2  3
     *
     * Выходные данные:
     * 8
     *
     *
     * Входные данные:
     4
     6 4 0 1
     8 7 0 3
     1 3 0 9
     7 5 1 2
     *
     * Выходные данные:
     * -65
     *
     *
     -1 -4 0 0 -2
     0 0 0 5 4
     3 1 7 1 0
     0 0 2 0 -3
     -1 0 4 2 2

     7
     1 2 3 4 5 6 1
     0 1 0 1 0 1 2
     2 3 1 3 1 3 3
     3 2 1 1 2 3 4
     6 5 4 3 2 1 5
     7 -3 -2 3 -2 1 0
     -5 -4 -3 -2 -1 0 3
     */
    private static boolean sign = true;

    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            double[][] matrix = getMatrix(reader);
            System.out.println(Math.round(gaussMethodDeterminant(matrix)));
        }
    }


    public static double[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        double[][] matrix  = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    public static double gaussMethodDeterminant(double[][] matrix) {
        sign = true;
        for (int k = 0; k < matrix.length; k++){
            reorderLines(matrix, k);
            for (int i = k + 1; i < matrix.length; i++) {
                if (roundResult(matrix[k][k], (int)Math.pow(10, 8)) == 0) {
                    matrix[k][k] = 0;
                    continue;
                }
                double n = - matrix[i][k] / matrix[k][k];
                for (int j = k; j < matrix.length; j++) {
                    matrix[i][j] += matrix[k][j] * n;
                }
            }
        }
        return determinantCount(matrix);
    }

    private static void reorderLines(double[][] matrix, int k) {
        for (int h = k; h < matrix.length; h++) {
            if (roundResult(matrix[h][k], (int)Math.pow(10, 8)) != 0) {
                if (h != k) {
                    swapLines(matrix, h, k);
                }
                break;
            }
        }
    }

    private static double determinantCount(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (roundResult(matrix[i][j], (int)Math.pow(10, 8)) != 0) {
                    if (i != j) {
                        swapLines(matrix, i, j);
                    }
                    break;
                }
            }
        }
        return resultCalculate(matrix, sign);
    }

    private static double roundResult (double d, int precise) {

        precise = 10^precise;
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;

    }

    private static double resultCalculate(double[][] matrix, boolean sign) {
        double determinant = 1;
        for (int j = 0; j < matrix.length; j++) {
            determinant *= roundResult(matrix[j][j], (int)Math.pow(10, 8));
        }
        return determinant * (sign ? 1 : -1);
    }

    private static void swapLines(double[][] matrix, int i, int j) {
        double[] temp = matrix[j];
        matrix[j] = matrix[i];
        matrix[i] = temp;
        sign = !sign;
    }

    private static void printMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}


