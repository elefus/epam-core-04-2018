package com.epam.homework;

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
        writeMatrix(rotateMatrix(matrix, degrees));
    }

    private static int[][] readMatrix(Scanner scanner){
        int dimension = scanner.nextInt();
        int [][] matrix = new int[dimension][dimension];

        for (int [] row : matrix) {
            for (int col = 0; col < dimension; col++) {
                row[col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] rotateMatrix(int[][]matrix, int degrees){
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        degrees = degrees % 4 < 0 ? degrees % 4 + 4 : degrees % 4;

        switch (degrees){
            case 1:
                return rotateMatrix90Deg(matrix, rotatedMatrix);
            case 2:
                return rotateMatrix180Deg(matrix, rotatedMatrix);
            case 3:
                return rotateMatrix270Deg(matrix, rotatedMatrix);
        }
        return matrix;
    }

    private static int[][] rotateMatrix90Deg(int[][] matrix, int[][] rotatedMatrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = matrix.length - 1; k > -1; k--) {
                rotatedMatrix[i][j++] = matrix[k][i];
            }
        }
        return rotatedMatrix;
    }

    private static int[][] rotateMatrix180Deg(int[][] matrix, int[][] rotatedMatrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
            }
        }
        return rotatedMatrix;
    }

    private static int[][] rotateMatrix270Deg(int[][] matrix, int[][] rotatedMatrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[i][j] = matrix[j][matrix.length - 1 - i];
            }
        }
        return rotatedMatrix;
    }

    private static void writeMatrix(int[][] matrix){
        System.out.println(matrix.length);

        for (int[] row : matrix) {
            StringBuilder builder = new StringBuilder();
            for (int col : row) {
                builder.append(col).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}
