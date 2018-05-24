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

    private static void printTurnedMatrix(int k) {
        k = (k < 0) ? k % 4 + 4 : k % 4;
        System.out.println(k);

        switch (k) {
            case 3:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        System.out.printf("%12d", matrix[j][dimension - 1 - i]);
                    }
                    System.out.println("\n");
                }
                break;
            case 2:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        System.out.printf("%12d", matrix[dimension - 1 - i][dimension - 1 - j]);
                    }
                    System.out.println("\n");
                }
                break;
            case 1:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        System.out.printf("%12d", matrix[dimension - 1 - j][i]);
                    }
                    System.out.println("\n");
                }
                break;
            default:
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        System.out.printf("%12d", matrix[i][j]);
                    }
                    System.out.println("\n");
                }
            }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        readMatrix(in);
        printTurnedMatrix(in.nextInt());
    }
}
