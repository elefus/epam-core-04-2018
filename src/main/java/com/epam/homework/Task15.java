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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        System.out.println(sumOfMatrixElements(matrix));
    }

    
    private static int sumOfMatrixElements(int[][] matrix) {
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean isFindFirstPositiveNumber = false;
            int sumInRow = 0;

            INNER:
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    if (!isFindFirstPositiveNumber) {
                        isFindFirstPositiveNumber = true;
                        continue INNER;
                    }
                    break INNER;
                }

                if (j == matrix[i].length - 1) {
                    sumInRow = 0;
                    continue INNER;
                }

                if (matrix[i][j] < 0 && isFindFirstPositiveNumber) {
                    sumInRow += matrix[i][j];
                }
            }
            result += sumInRow;
        }
        return result;
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

}