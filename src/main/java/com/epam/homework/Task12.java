package com.epam.homework;

import java.util.*;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     *
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int n = reader.nextInt();
            List<List<Integer>> matrix = getMatrix(reader, n);
            int compareRow = reader.nextInt();
            matrix.sort(Comparator.comparing(row -> row.get(compareRow)));

            printResult(n, matrix, compareRow);
        }
    }

    private static List<List<Integer>> getMatrix(Scanner reader, int n) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(reader.nextInt());
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static void printResult(int n, List<List<Integer>> matrix, int compareRow) {
        System.out.println(matrix.size());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
