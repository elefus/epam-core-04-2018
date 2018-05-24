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

    private static int dimension;
    private static int[][] matrix;

    private static void readMatrix(Scanner scanner) {
        dimension = scanner.nextInt();
        matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int sumOfNumsBetweenTwoPositiveNumsInOneRow(int row) {
        int sumOfNumsBetweenTwoPositiveNumsInOneRow = 0;
        int numOfPositiveNums = 0;

        for (int column = 0; column < dimension; column++) {
            if (numOfPositiveNums >= 2) {
                break;
            }
            if (matrix[row][column] < 0) {
                    sumOfNumsBetweenTwoPositiveNumsInOneRow += (numOfPositiveNums == 1) ? matrix[row][column] : 0;
            } else {
                numOfPositiveNums++;
            }
        }
        return sumOfNumsBetweenTwoPositiveNumsInOneRow;
    }

    private static int sumOfNumsBetweenTwoPositiveNumsInAllRows() {
        int sumOfNumsBetweenTwoPositiveNumsInAllRows = 0;
        if (dimension < 3) {
            return sumOfNumsBetweenTwoPositiveNumsInAllRows;
        }
        for (int i = 0; i < dimension; i++) {
            sumOfNumsBetweenTwoPositiveNumsInAllRows += sumOfNumsBetweenTwoPositiveNumsInOneRow(i);
        }
        return sumOfNumsBetweenTwoPositiveNumsInAllRows;
    }

    public static void main(String[] args) {
        readMatrix(new Scanner(System.in));
        System.out.println(sumOfNumsBetweenTwoPositiveNumsInAllRows());
    }
}
