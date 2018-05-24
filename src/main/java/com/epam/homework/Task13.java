package com.epam.homework;

import java.util.Scanner;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     *
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     *
     *
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     *
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */

    private static int dimension;
    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        dimension = scanner.nextInt();
        matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix() {
        System.out.println(dimension);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static int[][] shiftMatrix(int k) {
        if (dimension == 1 || k == 0) {
            return matrix;
        }

        int[][] shiftedMatrix = new int[dimension][dimension];
        k = (Math.abs(k) > dimension) ? k % dimension : k;

        if (k > 0) {
            System.arraycopy(matrix, 0, shiftedMatrix, k, dimension - k);
            System.arraycopy(matrix, dimension - k, shiftedMatrix, 0, k);
        } else {
            k = Math.abs(k);
            System.arraycopy(matrix, k, shiftedMatrix, 0, dimension - k);
            System.arraycopy(matrix, 0, shiftedMatrix, dimension - k, k);
        }

        return shiftedMatrix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readMatrix(in);
        matrix = shiftMatrix(in.nextInt());
        printMatrix();
    }
}
