package com.epam.homework;


import java.util.*;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
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
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     * <p>
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int matrixDimension = Math.abs(sc.nextInt());
        int[][] inputmatrix = readMatrix(sc, matrixDimension);
        int inputMoveCoeff = sc.nextInt();

        printMatrix(moveMatrix(inputmatrix, inputMoveCoeff));
    }

    private static int[][] moveMatrix(int[][] matrix, int moveCoeff) {
        boolean isPositive = (moveCoeff > 0);
        moveCoeff = Math.abs(moveCoeff);
        int dimension = matrix.length;
        int[][] answerMatrix = new int[dimension][];
        int realMoveCoeff = moveCoeff > dimension ? moveCoeff % dimension : moveCoeff;

        if (matrix.length == 1 || realMoveCoeff % dimension == 0 || realMoveCoeff == 0) {
            return matrix;
        }

        int row0Becomes = isPositive ? realMoveCoeff : (dimension - realMoveCoeff);

        System.arraycopy(matrix, 0, answerMatrix, row0Becomes, dimension - row0Becomes);
        if (isPositive) {
            System.arraycopy(matrix, row0Becomes - 1, answerMatrix, 0, row0Becomes);
        } else {
            System.arraycopy(matrix, dimension - realMoveCoeff, answerMatrix, 0, row0Becomes);
        }

        return answerMatrix;
    }

    private static int[][] readMatrix(Scanner scanner, int matrixDimension) {
        int[][] matrix = new int[matrixDimension][matrixDimension];
        for (int row = 0; row < matrixDimension; ++row) {
            for (int column = 0; column < matrixDimension; ++column) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                System.out.print(matrix[row][column] + "    ");
            }
            System.out.println();
        }
    }
}
