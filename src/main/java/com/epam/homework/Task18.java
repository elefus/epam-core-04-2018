package com.epam.homework;

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

        try (Scanner sc = new Scanner(System.in)) {
            int[][] initialMatrix = readMatrix(sc);
            int[][] matrixWithMaxRemoved = removeRowsAndColsWithMaxElement(initialMatrix);
            System.out.println(matrixWithMaxRemoved.length);
            System.out.println(matrixWithMaxRemoved[0].length);
            printMatrix(matrixWithMaxRemoved);
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

    private static int getMaxElement(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (aMatrix[j] > max) {
                    max = aMatrix[j];
                }
            }
        }
        return max;
    }

    private static int[][] removeRowsAndColsWithMaxElement(int[][] matrix) {
        int maxElement = getMaxElement(matrix);
        Set<Integer> rowsToDelete = new HashSet<>();
        Set<Integer> colsToDelete = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToDelete.add(i);
                    colsToDelete.add(j);
                }
            }
        }
        int[][] newMatrix = new int[matrix.length - rowsToDelete.size()][matrix.length - colsToDelete.size()];

        int rowsShift = 0;
        for (int i = 0; i < matrix.length; i++) {
            int colsShift = 0;  
            if (rowsToDelete.contains(i)) {
                rowsShift++;
            } else {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (colsToDelete.contains(j)) {
                        colsShift++;
                    } else {
                        newMatrix[i - rowsShift][j - colsShift] = matrix[i][j];
                    }
                }
            }
        }
        return newMatrix;
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
