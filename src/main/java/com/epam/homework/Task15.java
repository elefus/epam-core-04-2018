package com.epam.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task15 {

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     *  3
     *  1   0   3
     * -1   2   2
     *  1  -1   3
     *
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int[][] matrix = getMatrix(reader);
            int sum = Arrays.asList(matrix).stream().map(item ->
                    new LineSumCounter().countSum(item)
            ).mapToInt(i -> i).sum();
            System.out.println(sum);
        }
    }

    private static int[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        int[][] matrix  = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }
}

class LineSumCounter {
    private enum State {
        SEARCH_FIRST, COUNT_SUM
    }

    private int sum = 0;

    private State state = State.SEARCH_FIRST;

    public int countSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i ++) {
            switch (state) {
                case SEARCH_FIRST: {
                    if (array[i] > 0) {
                        state = State.COUNT_SUM;
                    }
                    break;
                }
                case COUNT_SUM: {
                    if (array[i] > 0) {
                        return sum;
                    }
                    sum += array[i];
                    break;
                }
            }
        }
        return 0;
    }
}

