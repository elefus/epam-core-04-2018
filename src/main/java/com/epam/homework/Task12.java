package com.epam.homework;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            int[][] matrix = new int[matrixDimension][matrixDimension];

            for (int i = 0; i < matrixDimension; i++) {
                for (int j = 0; j < matrixDimension; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }
            int sortColumnIndex = reader.nextInt();

            printMatrix(sortMatrix(matrix, sortColumnIndex));
        }
    }

    private static int[][] sortMatrix(int[][] matrix, int sortColumnIndex) {
        int[] sortColumn = getMatrixColumn(matrix, sortColumnIndex);

        Arrays.sort(sortColumn);

        for (int i = 0; i < sortColumn.length - 1; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (matrix[j][sortColumnIndex] == sortColumn[i]) {
                    swapMatrixLines(matrix, i, j);
                    break;
                }
            }
        }

        return matrix;
    }

    private static int[] getMatrixColumn(int[][] matrix, int columnIndex) {
        int[] matrixColumn = new int[matrix.length];

        for (int i = 0; i < matrixColumn.length; i++) {
            matrixColumn[i] = matrix[i][columnIndex];
        }

        return matrixColumn;
    }

    private static void swapMatrixLines(int[][] matrix, int i, int j) {
        int[] tmp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tmp;
    }

    private static void printMatrix(int[][] matrix) {
       for (int[] line: matrix) {
            for (int el: line) {
                System.out.format("%4d", el);
            }
            System.out.println();
        }
    }
}
