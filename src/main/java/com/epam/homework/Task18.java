package com.epam.homework;

import java.util.*;

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
        int[][] cleanMatrix = clean(matrix, getMax(matrix));

        System.out.println(cleanMatrix.length);
        System.out.println(cleanMatrix[0].length);
        print(cleanMatrix);
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

    private static int[][] clean(int[][] matrix, int el) {
        Pair<Set<Integer>, Set<Integer>> rowsAndColumnsToRemove = getRowsAndColumnsOfElement(matrix, el);
        Set<Integer> rowsToRemove = rowsAndColumnsToRemove.getFirst();
        Set<Integer> columnsToRemove = rowsAndColumnsToRemove.getSecond();
        int[][] cleanMatrix = new int[matrix.length - rowsToRemove.size()][matrix[0].length - columnsToRemove.size()];

        for (int rowN = 0, newRowN = 0; rowN < matrix.length; rowN++) {
            if (rowsToRemove.contains(rowN)) {
                continue;
            }

            for (int columnN = 0, newColumnN = 0; columnN < matrix[0].length; columnN++) {
                if (columnsToRemove.contains(columnN)) {
                    continue;
                }

                cleanMatrix[newRowN][newColumnN] = matrix[rowN][columnN];
                newColumnN++;
            }
            newRowN++;
        }

        return cleanMatrix;
    }

    private static Pair<Set<Integer>, Set<Integer>> getRowsAndColumnsOfElement(int[][] matrix, int el) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == el) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        return new Pair<>(rows, columns);
    }

    private static int getMax(int[][] matrix) {
        int maxEl = matrix[0][0];

        for (int[] row : matrix) {
            for (int el : row) {
                maxEl = Math.max(maxEl, el);
            }
        }

        return maxEl;
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
