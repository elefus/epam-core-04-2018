package com.epam.homework;

import java.util.Collection;
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

    private static int rowCount;
    private static int columnCount;
    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        rowCount = scanner.nextInt();
        columnCount = rowCount;
        matrix = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrixToPrint) {
        System.out.println(rowCount);
        System.out.println(columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%12d", matrixToPrint[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static int findMaxElementInMatrix(int[][] matrix) {
        int maxElement = matrix[0][0];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }

        return maxElement;
    }

    private static void deleteElementFromMatrix(int maxElement) {
        Set<Integer> rowsToDelete = new HashSet<>();
        Set<Integer> columnsToDelete = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }

        int newMatrixRowCount = rowCount - rowsToDelete.size();
        int newMatrixColumnCount = columnCount - columnsToDelete.size();
        int[][] matrixWithoutElement = new int[newMatrixRowCount][newMatrixColumnCount];
        int newMatrixRow = 0;
        int newMatrixColumn = 0;

        for (int i = 0; i < rowCount; i++) {
            if (rowsToDelete.contains(i)) {
                continue;
            }
            for (int j = 0; j < columnCount; j++) {
                if (!columnsToDelete.contains(j)) {
                    matrixWithoutElement[newMatrixRow][newMatrixColumn] = matrix[i][j];
                    newMatrixColumn++;
                }
            }
            newMatrixColumn = 0;
            newMatrixRow++;
        }

        matrix = matrixWithoutElement;
        rowCount = newMatrixRowCount;
        columnCount = newMatrixColumnCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readMatrix(in);
        deleteElementFromMatrix(findMaxElementInMatrix(matrix));
        printMatrix(matrix);
    }
}