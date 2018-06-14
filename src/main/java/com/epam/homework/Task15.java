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
     * -1  2   2
     * 1  -1   3
     * <p>
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        System.out.println(getSumBetweenFirstAndSecondPositiveValues(matrix));
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int getSumBetweenFirstAndSecondPositiveValues(int[][] matrix) {
        int sum = 0;

        for (int[] matrixRow : matrix) {
            int startIndex = 0;
            int endIndex = 0;
            int counter = 0;
            for (int i = 0; i < matrixRow.length; i++) {
                if (matrixRow[i] > 0) {
                    if (counter == 0) {
                        startIndex = i;
                    }
                    if (counter == 1) {
                        endIndex = i;
                        break;
                    }
                    counter++;
                }

            }
            for (int k = startIndex + 1; k < endIndex; k++) {
                sum += matrixRow[k];
            }
        }
        return sum;
    }
}




