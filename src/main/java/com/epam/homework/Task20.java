package com.epam.homework;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  1
     *  2
     *  4
     *  2  4 -2 -3
     *  0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */


    private static int rowOfMin = 0;
    private static int columnOfMin = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int newRow = scanner.nextInt();
            int newColumn = scanner.nextInt();
            int[][] matrix = readMatrix(scanner);
            findMin(matrix);
            matrix = getChangedMatrix(matrix, newRow, newColumn);
            printMatrix(matrix);
        }
    }


    private static void findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                if (matrix[i][y] < min) {
                    min = matrix[i][y];
                    rowOfMin = i;
                    columnOfMin = y;
                }
            }
        }
    }

    private static int[][] getChangedMatrix(int[][] matrix, int row, int column) {
        if (Integer.compare(rowOfMin, row) != 0) {
            changeRows(matrix, rowOfMin , row);
        }
        if (Integer.compare(column, columnOfMin) != 0) {
            changeColumns(matrix, columnOfMin, column);
        }
        return matrix;
    }
    private static void changeColumns(int[][] initialMatrix, int column, int newColumn) {
        for (int i = 0; i < initialMatrix.length; i++) {
            int aux;
            aux = initialMatrix[i][column];
            initialMatrix[i][column] = initialMatrix[i][newColumn];
            initialMatrix[i][newColumn] = aux;
        }
    }

    private static void changeRows(int[][] initialMatrix, int row, int newRow) {
        int[] auxRow = initialMatrix[row];
        initialMatrix[row] = initialMatrix[newRow];
        initialMatrix[newRow] = auxRow;
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
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
