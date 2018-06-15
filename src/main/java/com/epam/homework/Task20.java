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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        int minRow = 0;
        int minCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] < matrix[minRow][minCol]) {
                    minRow = row;
                    minCol = col;
                }
            }
        }
        swapRows(matrix, x, minRow);
        swapCol(matrix, y, minCol);
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

    private static void swapRows(int[][] matrix, int x, int minRow) {
        int[] temp = matrix[x];
        matrix[x] = matrix[minRow];
        matrix[minRow] = temp;

    }

    private static void swapCol(int[][] matrix, int y, int minCol) {
        int temp;
        for (int i = 0; i < matrix.length; ++i) {
            temp = matrix[i][y];
            matrix[i][y] = matrix[i][minCol];
            matrix[i][minCol] = temp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }

}

