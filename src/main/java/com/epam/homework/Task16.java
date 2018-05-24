package com.epam.homework;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     ...
     case  -5: поворот на 450* против часовой стрелки
     case  -4: поворот на 360* против часовой стрелки
     case  -3: поворот на 270* против часовой стрелки
     case  -2: поворот на 180* против часовой стрелки
     case  -1: поворот на  90* против часовой стрелки
     case   0: поворот не осуществляется
     case   1: поворот на  90* по     часовой стрелке
     case   2: поворот на 180* по     часовой стрелке
     case   3: поворот на 270* по     часовой стрелке
     case   4: поворот на 360* по     часовой стрелке
     case   5: поворот на 450* по     часовой стрелке
     ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     3
     1  -2   1
     -3   0   2
     3  -2   1
     1
     *
     * Выходные данные:
     3
     3  -3   1
     -2   0  -2
     1   2   1
     *
     *
     *
     * Входные данные:
     2
     9  3
     2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */

    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            double[][] matrix = getMatrix(reader);
            int degree = reader.nextInt();
            matrix = switchDegrees(degree, matrix);
            printMatrix(matrix);
        }
    }

    private static double[][] switchDegrees(int degrees, double[][] matrix) {
        switch (degrees) {
            case 3:
            case -1:
            case -5:
                return turnAntiClockWise90(matrix);
            case 0:
            case 4:
            case -4:
                return matrix;
            case 1:
            case 5:
            case -3:
                return turnClockWise90(matrix);
            case 2:
            case -2:
                return turnClockWise180(matrix);
        }
        return null;
    }

    private static double[][] turnClockWise180(double[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                result[n - 1 - i][n - 1 - j] = matrix[i][j];
            }
        }
        return result;
    }

    private static double[][] turnAntiClockWise90(double[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[n - j - 1][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static double[][] turnClockWise90(double[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = matrix[i][j];
            }
        }
        return result;
    }

    private static double[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        double[][] matrix  = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((int) matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
