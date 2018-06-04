package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private static List<Integer> rowOfMaxArray = new ArrayList<>();
    private static List<Integer> columnOfMaxArray = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            findMaxRowAndColumn(matrix);
            int[][] newMatrix = deletedMatrix(matrix);
            printMatrix(newMatrix);
        }
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                max = Math.max(max, anAMatrix);
            }
        }
        return max;
    }

    private static int[][] deletedMatrix(int[][] initialMatrix) {
        int[][] newMatrix =
                new int[initialMatrix.length-rowOfMaxArray.size()][initialMatrix.length-columnOfMaxArray.size()];
        int rows = 0;
        for (int i = 0; i < initialMatrix.length; i++) {
            int columns = 0;
            if (rowOfMaxArray.contains(i)) {
                rows++;
            }
            else {
                for (int y = 0; y < initialMatrix[0].length; y++) {
                    if (columnOfMaxArray.contains(y)) {
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

    private static void findMaxRowAndColumn(int[][] initialMatrix) {
        int max = findMax(initialMatrix);
        for (int i = 0; i < initialMatrix.length; i++){
            for (int y = 0; y < initialMatrix[i].length; y++) {
                if(initialMatrix[i][y] == max) {
                    if (!rowOfMaxArray.contains(i)) {
                        rowOfMaxArray.add(i);
                    }
                    if (!columnOfMaxArray.contains(y)) {
                        columnOfMaxArray.add(y);
                    }
                }
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
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
                System.out.printf("%12d", anAMatrix);

            }
            System.out.println("\n");
        }
    }
}
