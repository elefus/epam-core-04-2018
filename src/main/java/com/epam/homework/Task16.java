package com.epam.homework;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     * ...
     * case  -5: поворот на 450* против часовой стрелки
     * case  -4: поворот на 360* против часовой стрелки
     * case  -3: поворот на 270* против часовой стрелки
     * case  -2: поворот на 180* против часовой стрелки
     * case  -1: поворот на  90* против часовой стрелки
     * case   0: поворот не осуществляется
     * case   1: поворот на  90* по     часовой стрелке
     * case   2: поворот на 180* по     часовой стрелке
     * case   3: поворот на 270* по     часовой стрелке
     * case   4: поворот на 360* по     часовой стрелке
     * case   5: поворот на 450* по     часовой стрелке
     * ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1  -2   1
     * -3   0   2
     * 3  -2   1
     * 1
     * <p>
     * Выходные данные:
     * 3
     * 3  -3   1
     * -2   0  -2
     * 1   2   1
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 2
     * 9  3
     * 2  4
     * -2
     * <p>
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int k = scanner.nextInt();

        showMatrix(turnMatrix(matrix,k));
    }

    private static int[][] turnMatrix(int[][] matrix, int degrees) {

        degrees = degrees % 4;
        switch (degrees) {
            case 0:
                return matrix;
            case 1:
            case -3:
                return turnTo90(matrix);

            case 2:
            case -2:
                return turnTo180(matrix);

            case 3:
            case -1:
                return turnTo270(matrix);
            default:
                return matrix;
        }
    }

    private static int[][] turnTo90(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int j = 0, row = 0; j < matrix[0].length; j++, row++) {
            for (int i = matrix.length - 1, col = 0; i >= 0; i--, col++) {
                result[row][col] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] turnTo180(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int j = matrix.length -1, row = 0; j >= 0; j--, row++) {
            for (int i = matrix[j].length - 1, col = 0; i >= 0; i--, col++) {
                result[row][col] = matrix[j][i];
            }
        }
        return result;
    }

    private static int[][] turnTo270(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int j = matrix[0].length - 1, row = 0; j >= 0; j--, row++) {
            for (int i = 0, col = 0; i < matrix.length ; i++, col++) {
                result[row][col] = matrix[i][j];
            }
        }
        return result;
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

    private static void showMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}