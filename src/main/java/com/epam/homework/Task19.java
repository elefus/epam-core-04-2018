package com.epam.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private static List<Integer> columnsWithAllZeros;
    private static List<Integer> rowsWithAllZeros;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = readMatrix(scanner);

            findColumnsAndRowsWithAllZeros(matrix);
            matrix = newMatrix(matrix);
            printMatrix(matrix);
        }
    }


    private static int[][] newMatrix(int[][] initialMatrix) {
        int[][] newMatrix =
                new int[initialMatrix.length-rowsWithAllZeros.size()][initialMatrix.length-columnsWithAllZeros.size()];
        int rows = 0;
        for(int i = 0; i < initialMatrix.length; i++) {
            int columns = 0;
            if (rowsWithAllZeros.contains(i)) {
                rows++;
            }
            else {
                for (int y = 0; y < initialMatrix[i].length; y++) {
                    if (columnsWithAllZeros.contains(y)) {
                        columns++;
                    }
                    else {
                        newMatrix[i-rows][y-columns] = initialMatrix[i][y];
                    }
                }
            }
        }
        return newMatrix;
    }

    private static void findColumnsAndRowsWithAllZeros(int[][] matrix) {
        columnsWithAllZeros = new ArrayList<>();
        rowsWithAllZeros = new ArrayList<>();

        int[] aux = new int[matrix.length]; // по умолчанию все значения = 0

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (Arrays.equals(row, aux)) {
                rowsWithAllZeros.add(i);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            int y = 0;
            while (y < matrix[i].length) {
                column[y] = matrix[y][i];
                y++;
            }
            if (Arrays.equals(column, aux)) {
                columnsWithAllZeros.add(i);
            }
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

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
