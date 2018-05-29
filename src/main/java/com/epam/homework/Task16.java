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
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
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
        try (Scanner in = new Scanner(System.in)) {
            int matrixSize = Integer.parseInt(in.nextLine());
            int[][] matrix = readMatrix(in, matrixSize);
            int angle = in.nextInt();
            rotateMatrix(matrix, angle);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        return matrix;
    }


    private static void rotateMatrix(int[][] matrix, int angle) {

        System.out.println(matrix.length);

        angle %= 4;
        if (angle < 0) {
            angle += 4;
        }

        switch (angle) {
            case 0:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 1:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        System.out.print(matrix[j][i] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = matrix.length - 1; i >= 0; i--) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = matrix.length - 1; i >= 0; i--) {
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[j][i] + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
