package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printMatrix(newMatrix(matrix));
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int[] aMatrix = matrix[i];
            for (int j = 0; j < aMatrix.length; j++) {
                int anAMatrix = aMatrix[j];
                if (anAMatrix > max) {
                    max = anAMatrix;
                }
            }
        }
        return max;
    }

    private static int[][] rowDel(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length - set.size()][matrix[0].length];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!set.contains(i)) {
                newMatrix[count++] = matrix[i];
            }
        }
        return newMatrix;
    }

    private static int[][] colDel(int[][] matrix, Set<Integer> set) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length - set.size()];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!set.contains(j)) {
                    newMatrix[i][count++] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    private static int[][] newMatrix(int[][] inputMatrix) {
        int max = findMax(inputMatrix);
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int row = 0; row < inputMatrix.length; ++row) {
            for (int col = 0; col < inputMatrix[row].length; ++col) {
                if (inputMatrix[row][col] == max) {
                    rows.add(row);
                    columns.add(col);
                }
            }
        }
        inputMatrix = rowDel(inputMatrix, rows);
        inputMatrix = colDel(inputMatrix, columns);
        return inputMatrix;
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