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
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);
        int shift = scanner.nextInt();
        int[][] matrixShifted = matrixShift(matrix, dimension, shift);
        printMatrix(matrixShifted, dimension);
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix, int dimension) {
        System.out.println(dimension);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < dimension; col++) {
                System.out.print(aMatrix[col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixShift(int[][] matrix, int dimension, int shift) {
        if (shift == 0) {
            return matrix;
        }
        int[][] matrixShifted = new int[dimension][dimension];
        if (Math.abs(shift) > dimension) {
            shift = shift - (shift / dimension)*dimension;
        }
        int shiftedRow = (shift > 0) ? dimension - shift : Math.abs(shift);
        int beforeShiftedRow = 0;
        for (int i = 0; i < dimension; i++) {
            if (shiftedRow < dimension) {
                matrixShifted[i] = matrix[shiftedRow];
                shiftedRow++;
            } else {
                matrixShifted[i] = matrix[beforeShiftedRow];
                beforeShiftedRow++;
            }
        }
        return matrixShifted;
    }
}

