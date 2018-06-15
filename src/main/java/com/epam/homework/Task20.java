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
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int newRow = scanner.nextInt();
        int newCol = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);

        shiftRowsAndColForMinElement(matrix, newRow, newCol);
        printMatrix(matrix);

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
        int dimension = matrix.length;
        System.out.println(dimension);
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void shiftRows(int[][] matrix, int fromRow, int toRow) {

        int[] tempRow = matrix[fromRow];
        matrix[fromRow] = matrix[toRow];
        matrix[toRow] = tempRow;

    }

    private static void shiftCols(int[][] matrix, int fromCol, int toCol) {

        for (int[] row : matrix) {
            int tempElement = row[fromCol];
            row[fromCol] = row[toCol];
            row[toCol] = tempElement;
        }

    }

    private static void shiftRowsAndColForMinElement(int[][] matrix, int newRow, int newCol) {

        int dimension = matrix.length;
        int minElement = matrix[0][0];
        int iMin = 0;
        int jMin = 0;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    iMin = i;
                    jMin = j;
                }
            }
        }

        shiftRows(matrix, iMin, newRow);
        shiftCols(matrix, jMin, newCol);

    }

}
