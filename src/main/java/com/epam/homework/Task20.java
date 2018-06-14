package com.epam.homework;

import java.util.Scanner;
import java.util.stream.IntStream;

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
        Scanner scanner = new Scanner(System.in);

        int[] position = IntStream.range(0, 2)
                .map(i -> scanner.nextInt())
                .toArray();

        int[][] matrix = readMatrix(scanner);

        int[] minElement = findMinElement(matrix);

        matrix = swapRows(matrix, minElement[0], position[0]);
        matrix = swapColumns(matrix, minElement[1], position[1]);

        printMatrix(matrix);
    }

    private static int[] findMinElement(int[][] matrix) {
        int minElement = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    private static int[][] swapRows(int[][] matrix, int srcRow, int destRow) {
        int[] tempRow = matrix[srcRow];
        matrix[srcRow] = matrix[destRow];
        matrix[destRow] = tempRow;
        return matrix;
    }

    private static int[][] swapColumns(int[][] matrix, int srcColumn, int destColumn) {
        for (int[] row : matrix) {
            int tempElement = row[srcColumn];
            row[srcColumn] = row[destColumn];
            row[destColumn] = tempElement;
        }
        return matrix;
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
        for (int[] row: matrix) {
            StringBuilder result = new StringBuilder(String.valueOf(row[0]));
            for (int i = 1; i < row.length; i++) {
                result.append(String.format("   %2d", row[i]));
            }
            System.out.println(result);
        }
    }
}
