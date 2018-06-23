package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Scanner sc = new Scanner(System.in);
        int matrixDimension = sc.nextInt();
        int[][] matrix = readMatrix(sc, matrixDimension);

        printMatrix(solution(matrix));
    }

    private static int[][] solution(int[][] matrix) {
        Set<Integer> rowsToRemove = findRowsToDelete(matrix);
        Set<Integer> colToRemove = findColToDelete(matrix);
        int[][] answerMatrix = new int[matrix.length - rowsToRemove.size()][matrix.length - colToRemove.size()];
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            int col = 0;
            if (!rowsToRemove.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    if (!colToRemove.contains(j)) {
                        answerMatrix[row][col++] = matrix[i][j];
                    }
                }
                row++;
            }
        }
        return answerMatrix;
    }

    private static Set<Integer> findColToDelete(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        int counter = 0;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] != 0) continue;
                counter = matrix[row][col] == 0 ? ++counter : counter;
                if (counter == matrix.length) {
                    rowSet.add(col);
            }
        }
        counter = 0;
    }
        return rowSet;
}

    private static Set<Integer> findRowsToDelete(int[][] matrix) {
        Set<Integer> columnSet = new HashSet<>();
        int counter = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] != 0) continue;
                counter = matrix[row][col] == 0 ? ++counter : counter;
                if (counter == matrix.length) {
                    columnSet.add(row);
                }
            }
            counter = 0;
        }
        return columnSet;
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
        System.out.println(matrix[0].length);

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "   ");
            }
            System.out.println();
        }
    }
}

