package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
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
     *  3
     *  2  1 -3
     * -2  3  2
     * -1  0  0
     *
     * Выходные данные:
     *  2
     *  2
     *  2 -3
     * -1  0
     *
     *
     *
     * Входные данные:
     *  4
     *  3 -2 -4  1
     *  1  4  4  2
     * -1  0 -3  1
     *  0  2  1  3
     *
     * Выходные данные:
     *  3
     *  2
     *  3  1
     * -1  1
     *  0  3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        matrix = deleteAllRowsColumnsContains(matrix, findMaxElement(matrix));
        printMatrix(matrix);
    }

    private static int[][] deleteAllRowsColumnsContains(int[][] matrix, int elementToDelete) {
        Set<Integer> rowsToDelete = new HashSet<>();
        Set<Integer> columnsToDelete = new HashSet<>();

        //Mark rows and column of matrix to delete in case it contains max element
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == elementToDelete) {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }

        int count = 0;
        for (int rowToDelete : rowsToDelete) {
            matrix = deleteRow(matrix, rowToDelete - count++);
        }

        count = 0;
        for (int columnToDelete : columnsToDelete) {
            matrix = deleteColumn(matrix, columnToDelete - count++);
        }

        return matrix;
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
