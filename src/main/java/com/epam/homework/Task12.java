package com.epam.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     *
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int matrixDimension = reader.nextInt();
            int[][] matrix = readMatrix(reader, matrixDimension);
            int sortColumnIndex = reader.nextInt();

            printMatrix(sortMatrix(matrix, sortColumnIndex));
        }
    }

    static int[][] readMatrix(Scanner reader, int dimension) {
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }

        return matrix;
    }

    static int[][] sortMatrix(int[][] matrix, int sortColumnIndex) {
        Arrays.sort(matrix, Comparator.comparingInt(p -> p[sortColumnIndex]));

        return matrix;
    }

    static void printMatrix(int[][] matrix) {
       for (int[] line: matrix) {
            for (int el: line) {
                System.out.format("%4d", el);
            }
            System.out.println();
        }
    }
}
