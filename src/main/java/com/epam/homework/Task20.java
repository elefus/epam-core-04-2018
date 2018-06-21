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
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int rowToInsertMin = Integer.parseInt(sc.nextLine());
            int colToInsertMin = Integer.parseInt(sc.nextLine());
            int[][] initialMatrix = readMatrix(sc);
            int[][] matrixWithMinReplaced = getAndMoveMinElement(rowToInsertMin, colToInsertMin, initialMatrix);
            System.out.println(matrixWithMinReplaced.length);
            printMatrix(matrixWithMinReplaced);
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

    private static int[][] getAndMoveMinElement(int targetRow, int targetCol, int[][] matrix) {
        int minElement = Integer.MAX_VALUE;
        int rowContainingMin = 0;
        int colContainingMin = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    rowContainingMin = i;
                    colContainingMin = j;
                }
            }
        }

        int[] tempRow = matrix[rowContainingMin];
        matrix[rowContainingMin] = matrix[targetRow];
        matrix[targetRow] = tempRow;

        for (int[] row : matrix) {
            int tmp = row[colContainingMin];
            row[colContainingMin] = row[targetCol];
            row[targetCol] = tmp;
            }

        return matrix;
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
