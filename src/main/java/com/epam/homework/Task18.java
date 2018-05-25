package com.epam.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

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
     3
     2  1 -3
     -2  3  2
     -1  0  0
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
     4
     3 -2 -4  1
     1  4  4  2
     -1  0 -3  1
     0  2  1  3
     *
     * Выходные данные:
     3
     2
     3  1
     -1  1
     0  3
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int[][] matrix = getMatrix(reader);
            List<Coord> matrixEntries = getMatrixMaxEntries(matrix);
            matrix = deleteRowCols(matrix, matrixEntries);
            printMatrix(matrix);
        }
    }


    public static int[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        int[][] matrix  = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] deleteRowCols(int[][] matrix, List<Coord> matrixEntries) {
        Set<Integer> iToDelete = matrixEntries.stream().map(item -> item.getI()).collect(Collectors.toSet());
        Set<Integer> jToDelete = matrixEntries.stream().map(item -> item.getJ()).collect(Collectors.toSet());
        int oldSize = matrix.length;
        int[][] result = new int[oldSize - iToDelete.size()][oldSize - jToDelete.size()];
        for (int i = 0, newi = 0; i < oldSize; i++, newi++) {
            while (iToDelete.contains(i)) {
                i++;
            }
            for (int j = 0, newj = 0; j < oldSize; j++, newj++) {
                while (jToDelete.contains(j)) {
                    j++;
                }
                result[newi][newj] = matrix[i][j];
            }
        }
        return result;
    }

    private static List<Coord> getMatrixMaxEntries(int[][] matrix) {
        int n = matrix.length;
        int maxValue = Integer.MIN_VALUE;
        List<Coord> matrixEntries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue, matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == maxValue) {
                    matrixEntries.add(new Coord(i, j));
                }
            }
        }
        return matrixEntries;
    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    private static class Coord {
        private int i;
        private int j;
    }


    private static void printMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return;
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
