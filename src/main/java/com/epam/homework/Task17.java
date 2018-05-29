package com.epam.homework;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);

        System.out.println(countDet(matrix));

    }

    private static int countDet(int[][] matrix) {
        int sum = 0;
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            sum += (matrix[0][i] * Math.pow((-1), i) * countDet(generateNewArray(matrix, i)));
        }
        return sum;
    }

    private static int[][] generateNewArray(int[][] matrix, int col) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];

        for (int oldRow = 0, newRow = 0; oldRow < matrix.length; oldRow++, newRow++) {
            if (0 != oldRow) {
                for (int oldCol = 0, newCol = 0; oldCol < matrix.length; oldCol++, newCol++) {
                    if (col != oldCol) {
                        newMatrix[newRow][newCol] = matrix[oldRow][oldCol];
                    } else {
                        newCol--;
                    }
                }
            } else {
                newRow--;
            }
        }
        return newMatrix;
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
