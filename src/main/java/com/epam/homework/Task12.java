package com.epam.homework;

import java.util.Scanner;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     * <p>
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, size);
        int column = scanner.nextInt();
        sortMatrix(matrix, column);
        printMatrix(matrix);
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

    private static void sortMatrix(int[][] matrix, int index) {
        int[] addition;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1 - i; j++) {
                if (matrix[j][index] > matrix[j + 1][index]) {
                    addition = matrix[j + 1];
                    matrix[j + 1] = matrix[j];
                    matrix[j] = addition;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

