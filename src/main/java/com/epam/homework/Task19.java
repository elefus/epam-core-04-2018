package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        while (getNullRow(matrix) >= 0) {
            matrix = deleteRow(matrix, getNullRow(matrix));
        }

        while (getNullColumn(matrix) >= 0) {
            matrix = deleteColumn(matrix, getNullColumn(matrix));
        }

        printMatrix(matrix);
    }

    private static int[][] deleteRow(int[][] matrix, int rowToDelete) {
        if (rowToDelete >= 0 && rowToDelete < matrix.length) {
            int[][] result = new int[matrix.length - 1][matrix[0].length];
            System.arraycopy(matrix, 0, result, 0, rowToDelete);
            if (rowToDelete < matrix.length - 1) {
                System.arraycopy(matrix, rowToDelete + 1, result, rowToDelete,
                        matrix.length - rowToDelete - 1);
            }
            matrix = result;
        }
        return matrix;
    }

    private static int[][] deleteColumn(int[][] matrix, int columnToDelete) {
        if (columnToDelete >= 0 && columnToDelete < matrix[0].length) {
            int[][] result = new int[matrix.length ][matrix[0].length - 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.arraycopy(matrix[i],0, result[i], 0, columnToDelete);
                    if (columnToDelete < matrix[i].length - 1) {
                        System.arraycopy(matrix[i], columnToDelete + 1, result[i], columnToDelete,
                                matrix[i].length - columnToDelete - 1);
                    }
                }
            }
            matrix = result;
        }
        return matrix;
    }

    private static int getNullRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (Arrays.stream(matrix[i]).allMatch(element -> element == 0)) {
                return i;
            }
        }
        return -1;
    }

    private static int getNullColumn(int[][] matrix) {
        for (int column = 0; column < matrix[0].length; column++) {
            boolean isNull = true;
            for (int[] row : matrix) {
                if (row[column] != 0) {
                    isNull = false;
                    break;
                }
            }
            if (isNull) {
                return column;
            }
        }
        return -1;
    }

    private static int findMaxElement(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > maxElement) {
                    maxElement = element;
                }
            }
        }
        return maxElement;
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
        System.out.println(matrix[0].length);
        for (int[] row: matrix) {
            StringBuilder result = new StringBuilder(String.valueOf(row[0]));
            for (int i = 1; i < row.length; i++) {
                result.append(String.format("   %2d", row[i]));
            }
            System.out.println(result);
        }
    }
}
