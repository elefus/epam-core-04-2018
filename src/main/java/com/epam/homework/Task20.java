package com.epam.homework;

import java.util.*;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  1
     *  2
     *  4
     *  2  4 -2 -3
     *  0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowNumber = scanner.nextInt();
        int colNumber = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        matrix = matrixChange(matrix, rowNumber, colNumber);
        System.out.println(matrix.length);
        printMatrix(matrix);

    }

    public static int[][] matrixChange(int[][] matrix, int rowNumber, int colNumber) {
        Map<String, Integer> min = matrixMin(matrix);
        matrix = changeMatrixRow(reverseMatrix(matrix), colNumber, min.get("min col"));
        matrix = changeMatrixRow(reverseMatrix(matrix), rowNumber, min.get("min row"));

        return matrix;
    }

    public static int[][] changeMatrixRow (int[][] matrix, int rowNumber, int minRow) {
        if (rowNumber == minRow) return matrix;
        List <int[]> matrixChange = new LinkedList<>(Arrays.asList(matrix));
        matrixChange.remove(minRow);
        matrixChange.add(rowNumber, matrix[minRow]);
        for (int row = 0; row<matrix.length; row++) {
            matrix[row] = matrixChange.get(row);
        }
        return matrix;
    }

    private static Map<String, Integer> matrixMin (int[][] matrix) {
        Map<String, Integer> minPlace = new HashMap<>();
        int min = matrix[0][0];
        minPlace.put("min row", 0);
        minPlace.put("min col", 0);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                    minPlace.put("min row", row);
                    minPlace.put("min col", col);
                }
            }
        }
        return minPlace;
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

