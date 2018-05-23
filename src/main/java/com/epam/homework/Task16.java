package com.epam.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     *     ...
     *     case  -5: поворот на 450* против часовой стрелки
     *     case  -4: поворот на 360* против часовой стрелки
     *     case  -3: поворот на 270* против часовой стрелки
     *     case  -2: поворот на 180* против часовой стрелки
     *     case  -1: поворот на  90* против часовой стрелки
     *     case   0: поворот не осуществляется
     *     case   1: поворот на  90* по     часовой стрелке
     *     case   2: поворот на 180* по     часовой стрелке
     *     case   3: поворот на 270* по     часовой стрелке
     *     case   4: поворот на 360* по     часовой стрелке
     *     case   5: поворот на 450* по     часовой стрелке
     *     ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     *  1  -2   1
     * -3   0   2
     *  3  -2   1
     *  1
     *
     * Выходные данные:
     *  3
     *  3  -3   1
     * -2   0  -2
     *  1   2   1
     *
     *
     *
     * Входные данные:
     *  2
     *  9  3
     *  2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int degrees = scanner.nextInt();

        System.out.println(matrix.length);
        print(rotate(matrix, degrees));
    }

    private static int[][] rotate(int[][] matrix, int degrees) throws IllegalArgumentException {
        switch (degrees % 4) {
            // +90 equals to -270
            case 1:
            case -3:
                return turnClockwise(matrix);

            // +180 equals to -180
            case -2:
            case 2:
                return reverse(matrix);

            // -90 equals to +270
            case -1:
            case 3:
                return turnAntiClockwise(matrix);

            // for 0 degrees
            default:
                return matrix;
        }
    }

    private static int[][] reverse(int[][] matrix) {
        return reverseRows(reverseRowsOrder(matrix));
    }

    private static int[][] turnClockwise(int[][] matrix) {
        return doRowsAsColumns(reverseRowsOrder(matrix));
    }

    private static int[][] turnAntiClockwise(int[][] matrix) {
        return doRowsAsColumns(reverseRows(matrix));
    }

    private static int[][] doRowsAsColumns(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int rowN = 0; rowN < matrix.length; rowN++) {
            int[] row = matrix[rowN];

            for (int columnN = 0; columnN < row.length; columnN++) {
                newMatrix[columnN][rowN] = row[columnN];
            }
        }

        return newMatrix;
    }

    private static int[][] reverseRowsOrder(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));

        return matrix;
    }

    private static int[][] reverseRows(int[][] matrix) {
        for (int[] row: matrix) {
            reverse(row);
        }

        return matrix;
    }

    private static void reverse(int[] ar) {
        for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }
    }

    private static void print(int[][] matrix) {
        for (int[] row: matrix) {
            for (int el: row) {
                System.out.format("%4d", el);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }
}
