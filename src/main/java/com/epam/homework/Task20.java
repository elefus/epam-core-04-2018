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
        readMatrixAndMove(scanner);
    }

    private static int[][] moveMatrixToTarget(int[][] matrix, int dimension, int targetRow, int targetCol, int minRow, int minCol) {
        if ((targetRow == minRow) && (targetCol == minCol)) {
            return matrix;
        }

        int[] tempMatrix = new int[dimension];

        System.arraycopy(matrix[targetRow], 0, tempMatrix, 0, dimension);
        System.arraycopy(matrix[minRow], 0, matrix[targetRow], 0, dimension);
        System.arraycopy(tempMatrix, 0, matrix[minRow], 0, dimension);

        for (int i = 0; i < dimension; i++) {
            tempMatrix[i] = matrix[i][targetCol];
            matrix[i][targetCol] = matrix[i][minCol];
            matrix[i][minCol] = tempMatrix[i];
        }

        return matrix;
    }

    private static void readMatrixAndMove(Scanner scanner) {
        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();
        int dimension = scanner.nextInt();

        int min = Integer.MAX_VALUE;
        int minRow = 0;
        int minCol = 0;
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                    minRow = row;
                    minCol = col;
                }
            }
        }
        printMatrix(moveMatrixToTarget(matrix, dimension, targetRow, targetCol, minRow, minCol), dimension);
    }

    private static void printMatrix(int[][] matrix, int dimension) {
        System.out.println(dimension);
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                System.out.printf("%12d", matrix[row][col]);
            }
            System.out.println("\n");
        }
    }
}
