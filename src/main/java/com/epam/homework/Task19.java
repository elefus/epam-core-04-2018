package com.epam.homework;

import java.util.*;

import static java.util.Collection.*;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        matrix = matrixWithoutZero(matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        printMatrix(matrix);

    }

    public static int[][] matrixWithoutZero(int[][] matrix) {
        matrix = deleteLineMatrix(reverseMatrix(matrix));
        matrix = deleteLineMatrix(reverseMatrix(matrix));
        return matrix;
    }

    public static int[][] deleteLineMatrix(int[][] matrix) {
        Set<Integer> countDeleteLines = zeroLineCounter(matrix);
        int[][] matrixZeroOut = new int[matrix.length-countDeleteLines.size()][matrix[0].length];
        int count = 0;
        for (int row = 0; row<matrix.length; row++) {
            if (countDeleteLines.contains(row)) {
                count++;
            }
            else {
                matrixZeroOut[row-count] = matrix[row];
            }
        }
        return matrixZeroOut;
    }

    private static Set<Integer> zeroLineCounter (int[][] matrix) {
        int[] zeroLine = new int[matrix[0].length];
        Collections.fill(Arrays.asList(zeroLine), 0);
        Set<Integer> countDeleteLines = new HashSet<>();
        for (int i = 0; i<matrix.length; i++) {
            if (Arrays.equals(matrix[i], zeroLine)) {
                countDeleteLines.add(i);
            }
        }
        return countDeleteLines;
    }

    private static int[][] reverseMatrix(int[][] matrix) {
        int[][] matrixReverse = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrixReverse[col][row] = matrix[row][col];
            }
        }
        return matrixReverse;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%5d", aMatrix[col]);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
