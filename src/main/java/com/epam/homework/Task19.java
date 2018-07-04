package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  4
     *  2  0  0 -1
     *  0  0  0  0
     *  0  0  0  3
     * -3  0  0  1
     *
     * Выходные данные:
     *  3
     *  2
     *  2 -1
     *  0  3
     * -3  1
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] initialMatrix = readMatrix(sc);
            int[][] matrixWithoutZeros = removeAllZerosRowsAndCols(initialMatrix);
            System.out.println(matrixWithoutZeros.length);
            System.out.println(matrixWithoutZeros[0].length);
            printMatrix(matrixWithoutZeros);
        }
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


    private static int[][] removeAllZerosRowsAndCols(int[][] matrix) {
        Set<Integer> rowsToDelete = new HashSet<>();
        Set<Integer> colsToDelete = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    break;
                }
                if (j == matrix.length - 1) {
                    rowsToDelete.add(i);
                }
            }
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][i] != 0) {
                    break;
                }
                if (k == matrix.length - 1) {
                    colsToDelete.add(i);
                }
            }
        }
        int[][] newMatrix = new int[matrix.length - rowsToDelete.size()][matrix.length - colsToDelete.size()];

        int rowsShift = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToDelete.contains(i)) {
                rowsShift++;
            } else {
                int colsShift = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    if (colsToDelete.contains(j)) {
                        colsShift++;
                    } else {
                        newMatrix[i - rowsShift][j - colsShift] = matrix[i][j];
                    }
                }
            }
        }
        return newMatrix;
    }

    private static void printMatrix(int[][]matrix) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }
}
