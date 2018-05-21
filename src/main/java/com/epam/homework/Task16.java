package com.epam.homework;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
        ...
        case  -5: поворот на 450* против часовой стрелки
        case  -4: поворот на 360* против часовой стрелки
        case  -3: поворот на 270* против часовой стрелки
        case  -2: поворот на 180* против часовой стрелки
        case  -1: поворот на  90* против часовой стрелки
        case   0: поворот не осуществляется
        case   1: поворот на  90* по     часовой стрелке
        case   2: поворот на 180* по     часовой стрелке
        case   3: поворот на 270* по     часовой стрелке
        case   4: поворот на 360* по     часовой стрелке
        case   5: поворот на 450* по     часовой стрелке
        ...
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
3
1  -2   1
-3   0   2
3  -2   1
1
     *
     * Выходные данные:
     3
     3  -3   1
     * -2   0  -2
     1   2   1
     *
     *
     *
     * Входные данные:
     2
     9  3
     2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */

    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            double[][] matrix = getMatrix(reader);
            int degree = reader.nextInt();
            double[][] multiplyMatrix = switchDegrees(degree);
            double[][] resultMatrix = matrixMultiply(matrix, multiplyMatrix);
            printMatrix(resultMatrix);
        }
    }

    private static double[][] switchDegrees(int degrees) {
        switch (degrees) {
            case -5:
               return matrixRotationGenerator(-450);
            case -4:
               return matrixRotationGenerator(-360);
            case -3:
               return matrixRotationGenerator(-270);
            case -2:
               return matrixRotationGenerator(-180);
            case -1:
               return matrixRotationGenerator(-90);
            case 0:
               return matrixRotationGenerator(0);
            case 1:
               return matrixRotationGenerator(90);
            case 2:
               return matrixRotationGenerator(180);
            case 3:
               return matrixRotationGenerator(270);
            case 4:
               return matrixRotationGenerator(360);
            case 5:
               return matrixRotationGenerator(450);
        }
        return null;
    }
    
    private static double[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        double[][] matrix  = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((int) matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        double[][] resultMatrix = new double[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                resultMatrix[i][j] = matrixElementCounter(i, j, matrix1, matrix2);
            }
        }
        return resultMatrix;
    }

    private static double matrixElementCounter(int i, int j, double[][] matrix1, double[][] matrix2) {
        double result = 0;
        for (int k = 0; k < matrix1.length; k++) {
            result += matrix1[i][k] * matrix2[k][j];
        }
        return result;
    }

    private static double[][] matrixRotationGenerator(double angle) {
        double[][] rotationMatrix = new double[3][3];
        angle = Math.toRadians(angle);
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = - Math.sin(angle);
        rotationMatrix[1][0] = Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        rotationMatrix[2][2] = 1;
        rotationMatrix[2][0] = 0;
        rotationMatrix[2][1] = 0;
        rotationMatrix[0][2] = 0;
        rotationMatrix[1][2] = 0;
        return rotationMatrix;
    }
}
