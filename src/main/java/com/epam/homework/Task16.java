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
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);
        int degrees = scanner.nextInt();

        printMatrix(rotatedMatrix(matrix, degrees));

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

    private static void printMatrix(int[][] matrix){
        int dimension = matrix.length;
        System.out.println(dimension);
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotatedMatrix(int[][] matrix, int degrees){

        int dimension = matrix.length;
        int[][] newMatrix = new int[dimension][dimension];

        degrees %= 4;
        if (degrees < 0) degrees += 4;

        switch(degrees){
            case 0:
                break;
            case 1:
                for (int i = 0; i < dimension; i++){
                    for (int j = 0; j < dimension; j++){
                        newMatrix[i][j] = matrix[dimension - j - 1][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        newMatrix[i][j] = matrix[dimension - i - 1][dimension - j - 1];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        newMatrix[i][j] = matrix[j][dimension - i - 1];
                    }
                }
        }

        return newMatrix;

    }

}
