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
        Scanner sc = new Scanner(System.in);
        int matrixDimension = sc.nextInt();
        int answer = 0;
        int[][] inputMatrix = readMatrix(sc, matrixDimension);

        for (int currentrow = 0; currentrow < matrixDimension; currentrow++) {
            answer = getRowSum(inputMatrix, currentrow) + answer;
        }
        System.out.println(answer);
    }

    private static int getRowSum(int[][] matrix, int row) {
        int positiveNumCounter = 0;
        int rowSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] > 0) {
                positiveNumCounter++;
                continue;
            }
            if (positiveNumCounter == 2) {
                break;
            }
            if (positiveNumCounter == 1) {
                rowSum += matrix[row][i];
            }
        }
        return positiveNumCounter > 1 ? rowSum : 0;
    }

    private static int[][] readMatrix(Scanner scanner, int matrixDimension) {
        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int row = 0; row < matrixDimension; ++row) {
            for (int column = 0; column < matrixDimension; ++column) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
