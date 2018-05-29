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
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = readMatrix(scanner);
            int transformDigit = scanner.nextInt();
            matrix = transformMatrix(matrix, transformDigit);
            printMatrix(matrix);
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int y = 0; y < dimension; y++) {
                matrix[i][y] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            int[] aMatrix = matrix[i];
            for (int i1 = 0; i1 < aMatrix.length; i1++) {
                int anAMatrix = aMatrix[i1];
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transformMatrix(int[][] initialMatrix, int transformDigit) {
        if (transformDigit == 0 || initialMatrix.length == 1) {
            return initialMatrix;
        } else {
            return changeMatrixRows(initialMatrix, transformDigit);
        }
    }

    private static int[][] changeMatrixRows(int[][] initialMatrix, int transformDigit) {
        int[][] someMatrix = new int[initialMatrix.length][initialMatrix.length];
        int digitForRowsShifted = Math.abs(transformDigit) > initialMatrix.length ? Math.abs(transformDigit % initialMatrix.length) : Math.abs(transformDigit);
        if (digitForRowsShifted > 0) {
            System.arraycopy(initialMatrix, 0, someMatrix, digitForRowsShifted, initialMatrix.length-digitForRowsShifted);
            System.arraycopy(initialMatrix, initialMatrix.length-digitForRowsShifted, someMatrix, 0, digitForRowsShifted);
        } else {
            System.arraycopy(initialMatrix, digitForRowsShifted, someMatrix, 0, initialMatrix.length-digitForRowsShifted);
            System.arraycopy(initialMatrix, 0, someMatrix, initialMatrix.length-digitForRowsShifted, digitForRowsShifted);
        }
        return someMatrix;
    }
}