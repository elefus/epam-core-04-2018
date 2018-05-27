package com.epam.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
  4
  2  0  0 -1
  0  0  0  0
  0  0  0  3
 -3  0  0  1
     *
     * Выходные данные:
     *  3
     *  2
     *  2 -1
     *  0  3
     * -3  1
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int[][] matrix = getMatrix(reader);
            Pair zeroRowsAndCols = getZeroRowsCols(matrix);
            matrix = deleteRowCols(matrix, zeroRowsAndCols);
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

    private static int[][] deleteRowCols(int[][] matrix, Pair calsAndRowsToDelete) {
        Set<Integer> iToDelete = calsAndRowsToDelete.getNonZeroRows();
        Set<Integer> jToDelete = calsAndRowsToDelete.getNonZeroCols();
        int oldSize = matrix.length;
        int[][] result = new int[oldSize - iToDelete.size()][oldSize - jToDelete.size()];
        for (int i = 0, newi = 0; i < oldSize; i++, newi++) {
            while (iToDelete.contains(i)) {
                i++;
            }
            if (i >= oldSize) {
                break;
            }
            for (int j = 0, newj = 0; j < oldSize; j++, newj++) {
                while (jToDelete.contains(j)) {
                    j++;
                }
                if (j >= oldSize) {
                    break;
                }
                result[newi][newj] = matrix[i][j];
            }
        }
        return result;
    }

    private static Pair getZeroRowsCols(int[][] matrix) {
        Set<Integer> zeroRows = IntStream.range(0, matrix.length).boxed().collect(Collectors.toSet());
        Set<Integer> zeroCols = IntStream.range(0, matrix.length).boxed().collect(Collectors.toSet());
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    zeroCols.remove(j);
                    zeroRows.remove(i);
                }
            }
        }
        return new Pair(zeroRows, zeroCols);
    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    private static class Pair {
        private Set<Integer> nonZeroRows;
        private Set<Integer> nonZeroCols;
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
