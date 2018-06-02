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
        try (Scanner scanner = new Scanner(System.in)) {
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            getD(matrix);
        }
    }

    private static void getD(int[][] matrix) {
        int deter = getDeterminer(matrix);
        System.out.println(deter);
    }

    private static int getDeterminer(int[][] matrix) {
        int d = 0;
        if (matrix.length == 2) { // минор
            d += ((matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]));
        }
        else if (matrix.length < 2) {
            d += matrix[0][0];
        }
        else {
            int[] minorRow = matrix[0];
            int[][] minor = new int[matrix.length-1][matrix.length-1];
            for (int z = 0; z < matrix.length; z++) {
                for (int i = 1; i < matrix.length; i++) {
                    for (int y = z+1; y < matrix[i].length; y++) {
                        minor[i - 1][y - 1] = matrix[i][y];
                    }
                    for (int y = 0; y < z; y++) {
                        minor[i-1][y] = matrix[i][y];
                    }
                }
                int st = (int) Math.pow(-1, z+2);
                d += (st*minorRow[z])*getDeterminer(minor);
            }
        }
        return d;
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
}
