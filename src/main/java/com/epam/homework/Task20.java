package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
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
        int destinationRow = scanner.nextInt();
        int destinationCol = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);

        List<Integer> rowMoveNumber = new ArrayList<>(1);
        List<Integer> colMoveNumber = new ArrayList<>(1);

        setThePositionOfMinValue(rowMoveNumber, colMoveNumber, matrix);
        replaceRows(destinationRow, rowMoveNumber, matrix);
        replaceColumns(destinationCol, colMoveNumber, matrix);
        System.out.println(matrix.length);
        printMatrix(matrix);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int getMinValue(int[][] matrix) {
        int minValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int i = 0; i < matrix.length; i++) {
                minValue = Math.min(row[i], minValue);
            }
        }
        return minValue;
    }

    private static void setThePositionOfMinValue(List<Integer> row,
                                                 List<Integer> column,
                                                 int[][] matrix) {
        int minValue = getMinValue(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == minValue) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
    }

    private static void replaceRows(int destinationRow, List<Integer> rowMove, int[][] matrix) {
        int rowPosition = rowMove.get(0);
        int[] copyRow = matrix[rowPosition];
        matrix[rowPosition] = matrix[destinationRow];
        matrix[destinationRow] = copyRow;
    }

    private static void replaceColumns(int destinationCol, List<Integer> colMove, int[][] matrix) {
        int colPosition = colMove.get(0);
        int[] copyCol = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            copyCol[i] = matrix[i][colPosition];
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colPosition] = matrix[i][destinationCol];
            matrix[i][destinationCol] = copyCol[i];
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5d", row[j]);
            }
            System.out.println();
        }
    }
}