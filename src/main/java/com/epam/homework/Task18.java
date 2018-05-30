package com.epam.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
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
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        readMatrixAndFindMaximums(scanner, dimension);
    }

    private static void readMatrixAndFindMaximums(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                    rows.clear();
                    cols.clear();
                    rows.add(row);
                    cols.add(col);
                } else if (matrix[row][col] == max) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        clearArray(matrix, rows, cols);
    }

    private static void clearArray(int[][] matrix, Set<Integer> rows, Set<Integer> cols) {

        int newRowsLength = matrix.length - rows.size();
        int newColsLength = matrix.length - cols.size();
        int[][] newMatrix = new int[newRowsLength][newColsLength];

        for (int row = 0, newRow = 0; row < matrix.length; row++, newRow++) {

            if (rows.contains(row)) {
                newRow--;
                continue;
            }
            for (int col = 0, newCol = 0; col < matrix.length; col++, newCol++) {

                if (cols.contains(col)) {
                    newCol--;
                    continue;
                }
                newMatrix[newRow][newCol] = matrix[row][col];
            }
        }
        printMatrix(newMatrix, newRowsLength, newColsLength);
    }

    private static void printMatrix(int[][] matrix, int dimensionRows, int dimensionCols) {
        System.out.println(dimensionRows);
        System.out.println(dimensionCols);
        for (int row = 0; row < dimensionRows; ++row) {
            for (int col = 0; col < dimensionCols; ++col) {
                System.out.printf("%12d", matrix[row][col]);
            }
            System.out.println("\n");
        }
    }
}
