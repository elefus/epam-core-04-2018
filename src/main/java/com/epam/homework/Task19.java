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

    private static int rowCount;
    private static int columnCount;
    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        rowCount = scanner.nextInt();
        columnCount = rowCount;
        matrix = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrixToPrint) {
        System.out.println(rowCount);
        System.out.println(columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%12d", matrixToPrint[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static boolean isRowWithOnlyZeros(int row) {
        for (int i = 0; i < columnCount; i++) {
            if (matrix[row][i] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isColumnWithOnlyZeros(int column) {
        for (int i = 0; i < columnCount; i++) {
            if (matrix[i][column] != 0) {
                return false;
            }
        }

        return true;
    }

    private static void deleteRowsAndColumnsWithOnlyZerosFromMatrix() {

        int[][] matrixWithoutElement = new int[newMatrixRowCount][newMatrixColumnCount];
        int newMatrixRow = 0;
        int newMatrixColumn = 0;

        for (int i = 0; i < rowCount; i++) {
            if (!isRowsAndColumnsNotWithOnlyZeros[0].contains(i)) {
                continue;
            }
            for (int j = 0; j < columnCount; j++) {
                if (isRowsAndColumnsNotWithOnlyZeros[1].contains(j)) {
                    matrixWithoutElement[newMatrixRow][newMatrixColumn] = matrix[i][j];
                    newMatrixColumn++;
                }
            }
            newMatrixColumn = 0;
            newMatrixRow++;
        }

        matrix = matrixWithoutElement;
        rowCount = newMatrixRowCount;
        columnCount = newMatrixColumnCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readMatrix(in);
        deleteRowsAndColumnsWithOnlyZerosFromMatrix();
        printMatrix(matrix);
    }
}
