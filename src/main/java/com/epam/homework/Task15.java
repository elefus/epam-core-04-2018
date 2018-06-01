package com.epam.homework;

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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        System.out.println(sum(matrix));

    }

    private static int[][] readMatrix(Scanner scanner){
        int dimension = scanner.nextInt();
        int [][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int sum(int[][] matrix){
        int generalSum = 0;

        for (int[] rowMatrix : matrix) {
            int currentSum = 0;
            int count = 0;

            for (int colMatrix : rowMatrix) {
                if (colMatrix > 0) {
                    count++;
                }
                else if (count == 1) {
                    currentSum += colMatrix;
                }
                if (count == 2) {
                    generalSum += currentSum;
                    break;
                }
            }
        }
        return generalSum;
    }
}
