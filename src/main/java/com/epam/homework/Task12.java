package com.epam.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int [][] matrix = readMatrix(scanner, dimension);
        int colSelected = scanner.nextInt();
        matrixSort(matrix, dimension, colSelected);
        printMatrix(matrix, dimension);
    }

    private static int[][] readMatrix (Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row<dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix (int[][] matrix, int dimension) {
        System.out.println(dimension);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < dimension; col++) {
                System.out.print(aMatrix[col] + " ");
            }
            System.out.println();
        }
    }

    private  static void matrixSort (int[][] matrix, int dimension, int colSelected) {
        for (int i = 0; i<dimension; i++) {
            for (int j = 0; j < dimension -1; j++) {
                if (matrix[j][colSelected]>matrix[j+1][colSelected]) {
                    int[] key = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = key;
                }
            }
        }
    }

}
