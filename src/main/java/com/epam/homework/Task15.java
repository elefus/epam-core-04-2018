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
        try (Scanner in = new Scanner(System.in)) {
            int matrixSize = Integer.parseInt(in.nextLine());
            int[][] matrix = readMatrix(in, matrixSize);

            System.out.println(getSumBetweenFirstAndSecondPositiveElements(matrix));
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        return matrix;
    }

    private static int getSumBetweenFirstAndSecondPositiveElements(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {

            int positiveIndex1 = 0;
            int positiveIndex2 = 0;
            int numOfPositiveIndex = 0;

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] > 0) {

                    numOfPositiveIndex++;

                    switch (numOfPositiveIndex) {
                        case 1:
                            positiveIndex1 = j;
                            break;
                        case 2:
                            positiveIndex2 = j;
                            break;
                    }
                }
            }

            for (int j = positiveIndex1 + 1; j < positiveIndex2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
