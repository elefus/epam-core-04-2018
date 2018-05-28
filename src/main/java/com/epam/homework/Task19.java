package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        showMatrix(matrixWithoutNullRowsAndColumns(matrix));
    }

    private static Set<Integer> findNullRow(int[][] matrix) {
        Set<Integer> setOfNullRows = new HashSet<>();
        OUTER:
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                if (matrix[row][col] != 0) {
                    continue OUTER;
                }
            }
            setOfNullRows.add(row);
        }
        return setOfNullRows;
    }

    private static Set<Integer> findNullColumns(int[][] matrix) {
        Set<Integer> setOfNullColumns = new HashSet<>();
        OUTER:
        for (int col = 0; col < matrix[0].length; ++col) {
            for (int row = 0; row < matrix.length; ++row) {
                if (matrix[row][col] != 0) {
                    continue OUTER;
                }
            }
            setOfNullColumns.add(col);
        }
        return setOfNullColumns;
    }

    private static int[][] deleteRow(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length - set.size()][matrix[0].length];
        for (int i = 0, j = 0; i < matrix.length; i++) {
            if (!set.contains(i)) {
                newMatrix[j++] = matrix[i];
            }
        }
        return newMatrix;
    }

    private static int[][] deleteColumn(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length - set.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = 0; j < matrix[i].length; j++) {
                if (!set.contains(j)) {
                    newMatrix[i][k++] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }


    private static int[][] matrixWithoutNullRowsAndColumns(int[][] matrix) {
        matrix = deleteRow(matrix, findNullRow(matrix));
        matrix = deleteColumn(matrix, findNullColumns(matrix));
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

    private static void showMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}