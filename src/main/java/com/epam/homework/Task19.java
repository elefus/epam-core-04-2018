package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < elem < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */
    public static void main(String[] args) {
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        while (rowWith0(matrix) >= 0) {
            matrix = delRow(matrix, rowWith0(matrix));
        }
        while (colWith0(matrix) >= 0) {
            matrix = delCol(matrix, colWith0(matrix));
        }

        printMatrix(matrix);
    }

    private static int rowWith0(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (Arrays.stream(matrix[row]).allMatch(elem -> elem == 0)) {
                return row;
            }
        }
        return -1;
    }

    private static int colWith0(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            boolean that0 = true;
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                if (row[col] != 0) {
                    that0 = false;
                    break;
                }
            }
            if (that0) {
                return col;
            }
        }
        return -1;
    }

    private static int[][] delRow(int[][] matrix, int rowThatDel) {
        if (rowThatDel >= 0 && rowThatDel < matrix.length) {
            int[][] result = new int[matrix.length - 1][matrix[0].length];
            System.arraycopy(matrix, 0, result, 0, rowThatDel);
            if (rowThatDel < matrix.length - 1) {
                System.arraycopy(matrix, rowThatDel + 1, result, rowThatDel,
                        matrix.length - rowThatDel - 1);
            }
            matrix = result;
        }
        return matrix;
    }

    private static int[][] delCol(int[][] matrix, int colThatDel) {
        if (colThatDel >= 0 && colThatDel < matrix[0].length) {
            int[][] result = new int[matrix.length][matrix[0].length - 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.arraycopy(matrix[i], 0, result[i], 0, colThatDel);
                    if (colThatDel < matrix[i].length - 1) {
                        System.arraycopy(matrix[i], colThatDel + 1, result[i], colThatDel,
                                matrix[i].length - colThatDel - 1);
                    }
                }
            }
            matrix = result;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            int[] aMatrix = matrix[i];
            for (int j = 0; j < aMatrix.length; j++) {
                int anAMatrix = aMatrix[j];
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
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
}