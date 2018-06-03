package com.epam.homework;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     * ...
     * case  -5: поворот на 450* против часовой стрелки
     * case  -4: поворот на 360* против часовой стрелки
     * case  -3: поворот на 270* против часовой стрелки
     * case  -2: поворот на 180* против часовой стрелки
     * case  -1: поворот на  90* против часовой стрелки
     * case   0: поворот не осуществляется
     * case   1: поворот на  90* по     часовой стрелке
     * case   2: поворот на 180* по     часовой стрелке
     * case   3: поворот на 270* по     часовой стрелке
     * case   4: поворот на 360* по     часовой стрелке
     * case   5: поворот на 450* по     часовой стрелке
     * ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1  -2   1
     * -3   0   2
     * 3  -2   1
     * 1
     * <p>
     * Выходные данные:
     * 3
     * 3  -3   1
     * -2   0  -2
     * 1   2   1
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 2
     * 9  3
     * 2  4
     * -2
     * <p>
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);
        int degrees = scanner.nextInt();
        printMatrix(rotateMatrix(matrix, countRealDegrees(degrees)), dimension);
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

    private static void printMatrix(int[][] matrix, int dimension) {
        System.out.println(dimension);
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                System.out.printf("%12d", matrix[row][col]);
            }
            System.out.println("\n");
        }
    }

    private static int countRealDegrees(int degree) {
        if (degree == 0) {
            return 0;
        }
        degree = degree % 4;
        return (degree < 0) ? (4 + degree) : degree;
    }

    /**
     * If you want to rotate 90 degrees clockwise - use "1"
     * If you want to rotate 90 degrees counterclockwise - use "3"
     * If you want to rotate 180 degrees - use "2"
     * If you don't want to rotate - use "0"
     *
     * @param matrix - matrix
     * @param degree - degrees to rotate
     * @return - return rotated matrix
     */
    private static int[][] rotateMatrix(int[][] matrix, int degree) {
        int dimension = matrix.length;
        for (int row = 0; row < dimension / 2; row++) {
            for (int col = row; col < dimension - 1 - row; col++) {
                int tmp = matrix[row][col];
                switch (degree) {
                    case 0: //no rotate
                        return matrix;
                    case 1: // 90 degrees clockwise
                        matrix[row][col] = matrix[dimension - 1 - col][row];
                        matrix[dimension - 1 - col][row] = matrix[dimension - 1 - row][dimension - 1 - col];
                        matrix[dimension - 1 - row][dimension - 1 - col] = matrix[col][dimension - 1 - row];
                        matrix[col][dimension - 1 - row] = tmp;
                        break;
                    case 3: // 90 degrees counterclockwise
                        matrix[row][col] = matrix[col][dimension - 1 - row];
                        matrix[col][dimension - 1 - row] = matrix[dimension - 1 - row][dimension - 1 - col];
                        matrix[dimension - 1 - row][dimension - 1 - col] = matrix[dimension - 1 - col][row];
                        matrix[dimension - 1 - col][row] = tmp;
                        break;
                    case 2: // 180 degrees
                        matrix[row][col] = matrix[dimension - 1 - row][dimension - 1 - col];
                        matrix[dimension - 1 - row][dimension - 1 - col] = tmp;
                        tmp = matrix[col][dimension - 1 - row];
                        matrix[col][dimension - 1 - row] = matrix[dimension - 1 - col][row];
                        matrix[dimension - 1 - col][row] = tmp;
                        break;
                }
            }
        }
        return matrix;
    }
}
