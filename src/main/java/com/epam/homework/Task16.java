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
        int[][] matrix = readMatrix(scanner);
        int rotationAngle = scanner.nextInt();

        System.out.println(matrix.length);

        rotationAngle %= 4;
        if (rotationAngle < 0) {
            rotationAngle += 4;
        }
        switch (rotationAngle) {
            case 0:
                printMatrix(matrix);
                break;
            case 1:
                clockwiseMatrixRotation90(matrix);
                break;
            case 2:
                clockwiseMatrixRotation180(matrix);
                break;
            case 3:
                clockwiseMatrixRotation270(matrix);
                break;
        }
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

    private static void printMatrix(int[][] matrix) {
        int matrixDimension = matrix.length;

        for (int[] row : matrix) {
            for (int j = 0; j < matrixDimension; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    private static void clockwiseMatrixRotation90(int[][] matrix) {
        int matrixDimension = matrix.length;

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                System.out.print(matrix[matrixDimension - 1 - j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void clockwiseMatrixRotation180(int[][] matrix) {
        int matrixDimension = matrix.length;

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                System.out.print(matrix[matrixDimension - 1 - i][matrixDimension - 1 - j] + " ");
            }
            System.out.println();
        }
    }

    private static void clockwiseMatrixRotation270(int[][] matrix) {
        int matrixDimension = matrix.length;

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                System.out.print(matrix[j][matrixDimension - 1 - i] + " ");
            }
            System.out.println();
        }
    }

}
