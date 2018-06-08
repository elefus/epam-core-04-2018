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
        int step = scanner.nextInt();
        printMatrix(moveMatrix(matrix, step, dimension), dimension);
    }

    private static int[][] moveMatrix(int[][] matrix, int step, int dimension) {
        if (step == 0) {
            return matrix;
        }

        int realStep = step % dimension;
        int[] tempMatrix = new int[dimension];

        if (realStep < 0) {
            realStep = dimension + realStep;
        }

        int nextStep;
        int currentStep = 0;
        for (int row = 0; row < dimension; ++row) {

            nextStep = (dimension - realStep + currentStep) % dimension;

            for (int col = 0; col < dimension; ++col) {
                if (row == 0) {
                    tempMatrix[col] = matrix[0][col];
                }
                matrix[currentStep][col] = matrix[nextStep][col];
            }
            if (nextStep != 0) {
                currentStep = nextStep;
            }

        }
        System.arraycopy(tempMatrix, 0, matrix[currentStep], 0, dimension);
        return matrix;
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
