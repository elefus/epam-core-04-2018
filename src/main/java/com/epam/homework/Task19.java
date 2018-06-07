package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        int[][] packedMatrix = pack(matrix);

        System.out.println(packedMatrix.length);
        System.out.println(packedMatrix[0].length);
        print(packedMatrix);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] pack(int[][] matrix) {
        Pair<Set<Integer>, Set<Integer>> rowsAndColumnsToRemain = getNotNullRowsAndColumnsOf(matrix);
        Set<Integer> rowsToRemain = rowsAndColumnsToRemain.getFirst();
        Set<Integer> columnsToRemain = rowsAndColumnsToRemain.getSecond();
        int[][] packedMatrix = new int[rowsToRemain.size()][columnsToRemain.size()];

        for (int rowN = 0, newRowN = 0; rowN < matrix.length; rowN++) {
            if (!rowsToRemain.contains(rowN)) {
                continue;
            }

            for (int columnN = 0, newColumnN = 0; columnN < matrix[0].length; columnN++) {
                if (!columnsToRemain.contains(columnN)) {
                    continue;
                }

                packedMatrix[newRowN][newColumnN] = matrix[rowN][columnN];
                newColumnN++;
            }
            newRowN++;
        }

        return packedMatrix;
    }

    private static Pair<Set<Integer>, Set<Integer>> getNotNullRowsAndColumnsOf(int[][] matrix) {
        Set<Integer> notNullrows = new HashSet<>();
        Set<Integer> notNullcolumns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    notNullrows.add(i);
                    notNullcolumns.add(j);
                }
            }
        }

        return new Pair<>(notNullrows, notNullcolumns);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int el : row) {
                System.out.printf("%4d", el);
            }
            System.out.println();
        }
    }

    static class Pair <F, S> {
        private F first;
        private S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        F getFirst() {
            return first;
        }

        S getSecond() {
            return second;
        }
    }
}
