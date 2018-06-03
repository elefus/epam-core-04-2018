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
        Scanner in = new Scanner(System.in);
        int[][] matrix = readMatrix(in);
        System.out.println(totalSum(matrix));

    }

    private static int sumRow(int[] row) {
        int positiveElements = 0;
        int sum = 0;
        for (int elements : row) {
            if (elements > 0) {
                positiveElements++;
            } else if (positiveElements == 1) {
                sum += elements;
            }
        }
        return (positiveElements < 2) ? 0 : sum;
    }

    private static int totalSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += sumRow(row);
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner in) {
        int dimension = in.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = in.nextInt();
            }
        }
        return matrix;
    }
}
