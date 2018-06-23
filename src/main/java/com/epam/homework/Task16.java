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
        Scanner sc = new Scanner(System.in);
        int[][] givenMatrix = readMatrix(sc);
        int rotationDegree = Integer.parseInt(sc.next());
        int[][] rotatedMatrix = rotateMatrix(givenMatrix, rotationDegree);
        printMatrix(rotatedMatrix);
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
        System.out.println(matrix.length);

        for (int[] matrixElement : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrixElement[j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] rotateMatrix(int[][] matrix, int n) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        n %= 4;
        if (n < 0) {
            n += 4;
        }

        switch (n) {

            case 1:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        rotatedMatrix[i][j] = matrix[matrix.length - 1 - j][i];
                    }
                }
                return rotatedMatrix;
            case 2:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        rotatedMatrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                    }
                }
                return rotatedMatrix;
            case 3:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        rotatedMatrix[i][j] = matrix[j][matrix.length - 1 - i];
                    }
                }
                return rotatedMatrix;
        }

        return matrix;
    }

}
