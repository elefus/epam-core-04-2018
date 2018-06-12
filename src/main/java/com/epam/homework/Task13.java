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
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     * <p>
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     * <p>
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int k = scanner.nextInt();

        showMatrix(circleTurnMatrix(matrix, k));
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

    private static int[][] circleTurnMatrix(int[][] matrix, int number) {
        if (matrix.length == 1) return matrix;
        number %= matrix.length;
        if (number == 0) return matrix;
        if (number < 0) {
            number = matrix.length + number;
        }

        for (int j = 0; j < number; j++) {
            int[] memoryRow = matrix[matrix.length - 1];
            for (int i = matrix.length - 1; i >= 1; i--) {
                matrix[i] = matrix[i - 1];
            }
            matrix[0] = memoryRow;
        }
        return matrix;
    }
}

