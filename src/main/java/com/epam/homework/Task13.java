package com.epam.homework;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.Scanner;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     *
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     *
     *
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     *
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int indexColumn = scanner.nextInt();
        int[][] sortMatrix = sortMatrix(matrix, indexColumn);
        writeMatrix(sortMatrix);
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

    private static int[][] sortMatrix(int[][] matrix, int index){
        int[][] extra = new int[matrix.length][];
        int residual = Math.abs(index % matrix.length);

        if (residual == 0){
            return matrix;
        } else if (index < 0){
            System.arraycopy(matrix, residual, extra, 0, extra.length - residual);
            System.arraycopy(matrix, 0, extra, extra.length - residual, residual);
        } else {
            System.arraycopy(matrix, matrix.length - residual, extra, 0, residual);
            System.arraycopy(matrix, 0, extra, residual, matrix.length - residual);
        }
        return extra;
    }

    static void writeMatrix(int[][] matrix){
        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < matrix.length; col++) {
                builder.append(matrix[row][col]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}
