package com.epam.homework;

import java.util.*;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     *
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int indexColumn = scanner.nextInt();
        sortMatrix(matrix, indexColumn);
        writeMatrix(matrix);
    }

    private static int[][] readMatrix(Scanner scanner){
        int dimension = scanner.nextInt();
        int [][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void sortMatrix(int[][] matrix, int index){
        int[] extra;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1 - i; j++) {
                if (matrix[j][index] > matrix[j + 1][index]){
                    extra = matrix[j + 1];
                    matrix[j + 1] = matrix[j];
                    matrix[j] = extra;
                }
            }
        }
    }

    static void writeMatrix(int[][] matrix){
        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < matrix.length; col++) {
                builder.append(matrix[row][col]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}
