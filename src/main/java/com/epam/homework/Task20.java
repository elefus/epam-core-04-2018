package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        int rowDest = scanner.nextInt();
        int colDest = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        int rowPosOfMin = searchPositionOfMin(matrix)[0];
        int colPosOfMin = searchPositionOfMin(matrix)[1];
        replaceRowColOfDestToMin(matrix, rowPosOfMin, colPosOfMin, rowDest, colDest);
        writeMatrix(matrix);
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

    private static int[] searchPositionOfMin(int[][] matrix){
        int min = Integer.MAX_VALUE;
        int[] positionOfMin = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] < min){
                    min = matrix[row][col];
                    positionOfMin[0] = row;
                    positionOfMin[1] = col;
                }
            }
        }
        return positionOfMin;
    }

    private static void replaceRowColOfDestToMin(int[][] matrix, int rowPosOfMin, int colPosOfMin, int rowDest, int colDest){
        int[] tempRow = matrix[rowDest];
        int tempCol = 0;
        matrix[rowDest] = matrix[rowPosOfMin];
        matrix[rowPosOfMin] = tempRow;

        for (int[] row : matrix) {
            tempCol = row[colDest];
            row[colDest] = row[colPosOfMin];
            row[colPosOfMin] = tempCol;
        }
    }

    private static void writeMatrix(int[][] matrix){
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int[] row : matrix) {
            StringBuilder builder = new StringBuilder();
            for (int col : row) {
                builder.append(col).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}
