package com.epam.homework;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     *     ...
     *     case  -5: поворот на 450* против часовой стрелки
     *     case  -4: поворот на 360* против часовой стрелки
     *     case  -3: поворот на 270* против часовой стрелки
     *     case  -2: поворот на 180* против часовой стрелки
     *     case  -1: поворот на  90* против часовой стрелки
     *     case   0: поворот не осуществляется
     *     case   1: поворот на  90* по     часовой стрелке
     *     case   2: поворот на 180* по     часовой стрелке
     *     case   3: поворот на 270* по     часовой стрелке
     *     case   4: поворот на 360* по     часовой стрелке
     *     case   5: поворот на 450* по     часовой стрелке
     *     ...
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
     *  3
     *  1  -2   1
     * -3   0   2
     *  3  -2   1
     *  1
     *
     * Выходные данные:
     *  3
     *  3  -3   1
     * -2   0  -2
     *  1   2   1
     *
     *
     *
     * Входные данные:
     *  2
     *  9  3
     *  2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int degrees = scanner.nextInt();
        printMatrix(rotateMatrix(matrix, degrees));
    }

    private static int[][] rotateMatrix(int[][] matrix, int degrees) {
        degrees %= 4;
        degrees = degrees > 0 ? Math.abs(degrees - 4) : Math.abs(degrees);
        for (int i = 0; i < degrees; i++) {
            matrix = rotateMatrix90DegreesLeft(matrix);
        }
        return matrix;
    }

    private static int[][] rotateMatrix90DegreesLeft(int[][] matrix) {
        int matrixSize = matrix.length - 1;
        for (int i = 0; i <= matrixSize - 1; i++) {
            for (int j = i; j <= matrixSize - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][matrixSize - i];
                matrix[j][matrixSize - i] = matrix[matrixSize - i][matrixSize - j];
                matrix[matrixSize - i][matrixSize - j] = matrix[matrixSize - j][i];
                matrix[matrixSize - j][i] = temp;
            }
        }
        return matrix;
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

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int[] row: matrix) {
            StringBuilder result = new StringBuilder(String.valueOf(row[0]));
            for (int i = 1; i < row.length; i++) {
                result.append(String.format("   %2d", row[i]));
            }
            System.out.println(result);
        }
    }
}
