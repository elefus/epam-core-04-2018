package com.epam.homework;

import java.util.Scanner;

public class Task15 {


    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1   0   3
     * -1   2   2
     * 1  -1   3
     * <p>
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {
        // TODO реализация
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, N);
            System.out.println(summ(matrix, N));
        }
    }


    private static int summ(int[][] matrix, int N) {
        int sum = 0;
        int index = 0;
        int count = 1;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                if ((matrix[row][col] > 0)) {
                    if (count == 2) {
                        sum += matrixSumm(matrix[row], index, col);
                        break;
                    }
                    count++;
                    index = col;
                }
            }
            count = 1;
            index = 0;
        }
        return sum;
    }


    private static int matrixSumm(int[] matrix, int index, int col) {
        int sum = 0;
        for (int i = index + 1; i < col; i++) {
            sum += matrix[i];
        }
        return sum;
    }


    private static int[][] readMatrix(Scanner scanner, int N) {

        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
