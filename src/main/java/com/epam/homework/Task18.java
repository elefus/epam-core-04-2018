package com.epam.homework;

import java.util.*;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
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
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int maxMatrix = maxMatrix(matrix);
        matrix = matrixWithoutMax(matrix, maxMatrix);
        printMatrix(matrix);
    }

    public static int[][] matrixWithoutMax(int[][] matrix, int maxMatrix) {
        Set<Integer> rowCut = new HashSet<>();
        Set<Integer> colCut = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == maxMatrix) {
                    rowCut.add(row);
                    colCut.add(col);
                }
            }
        }
        int[][] matrixCut = new int[matrix.length - rowCut.size()][matrix.length - colCut.size()];
        int countCutRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            int countCutCol = 0;
            if (rowCut.contains(row)) {
                countCutRow++;
            } else {
                for (int col = 0; col < matrix.length; col++) {
                    if (colCut.contains(col)) {
                        countCutCol++;
                    } else
                        matrixCut[row - countCutRow][col - countCutCol] = matrix[row][col];
                }
            }
        }
        return matrixCut;
    }

    private static int maxMatrix(int[][] matrix) {
        int maxMatrix = matrix[0][0];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] > maxMatrix) {
                    maxMatrix = matrix[row][col];
                }
            }
        }
        return maxMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
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
