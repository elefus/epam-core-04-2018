package com.epam.homework;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */

    private static int rowOfMin = 0;
    private static int colOfMin = 0;
    public static void main(String[] args) {
        // TODO реализация
        try (Scanner scanner = new Scanner(System.in)) {
            int newRow = scanner.nextInt();
            int newCol = scanner.nextInt();
            int[][] matrix = readMatrix(scanner);
            findMin(matrix);
            matrix = newMatrix(matrix, newRow, newCol);
            printMatrix(matrix);
        }
    }

    private static void findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    rowOfMin = i;
                    colOfMin = j;
                }
            }
        }
    }

    private static int[][] newMatrix(int[][] matrix, int row, int col) {
        if (Integer.compare(rowOfMin, row) != 0) {
            changeRow(matrix, rowOfMin, row);
        }
        if (Integer.compare(col, colOfMin) != 0) {
            changeCol(matrix, colOfMin, col);
        }
        return matrix;
    }

    private static void changeRow(int[][] inMatrix, int row, int newRow) {
        int[] tempRow = inMatrix[row];
        inMatrix[row] = inMatrix[newRow];
        inMatrix[newRow] = tempRow;
    }

    private static void changeCol(int[][] inMatrix, int col, int newCol) {
        for (int i = 0; i < inMatrix.length; i++) {
            int tempCol;
            tempCol = inMatrix[i][col];
            inMatrix[i][col] = inMatrix[i][newCol];
            inMatrix[i][newCol] = tempCol;
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

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            int[] aMatrix = matrix[i];
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(aMatrix[col] + " ");
            }
            System.out.println();
        }
    }
}