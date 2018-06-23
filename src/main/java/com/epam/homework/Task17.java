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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            printDeterminant(matrix);

    }

    private static void printDeterminant(int[][] matrix) {
        int deter = determinant(matrix);
        System.out.println(deter);
    }

    private static int determinant(int[][] matrix) {
        int det = 0;
        switch (matrix.length) {
            case 2:
                det += ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
                break;
            case 1:
                det += matrix[0][0];
                break;
            case 0:
                det += matrix[0][0];
                break;
            default: {
                int[] minorRow = matrix[0];
                int[][] minor = new int[matrix.length - 1][matrix.length - 1];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 1; j < matrix.length; j++) {
                        for (int z = i + 1; z < matrix[j].length; z++) {
                            minor[j - 1][z - 1] = matrix[j][z];
                        }
                        for (int z = 0; z < i; z++) {
                            minor[j - 1][z] = matrix[j][z];
                        }
                    }
                    int a = (int) Math.pow(-1, i + 2);
                    det += (a * minorRow[i]) * determinant(minor);
                }
                break;

            }
        }
        return det;
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
