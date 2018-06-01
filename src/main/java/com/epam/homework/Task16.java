package com.epam.homework;

import java.util.Arrays;
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
        try (Scanner scanner = new Scanner(System.in)) {
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            int degree = scanner.nextInt();
            degree = Math.abs(degree) > 4 ? degree % 4 : degree;
            printMatrix(turnMatrix(matrix, degree), dimension);
        }
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

    private static int[][] turnMatrix(int[][] initialMatrix, int degree) {
        int[][] newInitialMatrix = initialMatrix;
        int[][] auxMatrix = new int[newInitialMatrix.length][newInitialMatrix.length];
        int[] helper = new int[newInitialMatrix.length];
        if (degree > 0) {
            for (int d = degree; d > 0; d--) {
                for (int i = 0; i < newInitialMatrix.length; i++) {
                    int[] row = newInitialMatrix[i];
                    System.arraycopy(row, 0, helper, 0, row.length);
                    System.out.println(Arrays.toString(helper));
                    for (int k = 0; k < helper.length; k++) {
                        auxMatrix[k][newInitialMatrix.length - 1 - i] = helper[k];
                    }
                }
                newInitialMatrix = auxMatrix;
            }
            return newInitialMatrix;
        }
        else if (degree < 0) {
            return auxMatrix;
        }
        else {
            return newInitialMatrix;
        }
    }

    private static void printMatrix(int[][] matrix, int dimension) {
        System.out.println(dimension);
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                System.out.printf("%12d", matrix[row][col]);
            }
            System.out.println("\n");
        }
    }
}
