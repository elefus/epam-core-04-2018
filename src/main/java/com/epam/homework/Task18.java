package com.epam.homework;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Task18 {


    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.maximum_VALUE)
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

        int maxElement = maximum(matrix);

        Set<Integer> rowsHasToBeRemoved = new HashSet<>();
        Set<Integer> columnsHasToBeRemoved = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsHasToBeRemoved.add(i);
                    columnsHasToBeRemoved.add(j);
                }
            }
        }
        printMatrix(removeNeededRow(matrix, rowsHasToBeRemoved, columnsHasToBeRemoved));

    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
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

    private static int[][] removeNeededRow(int[][] matrix, Set<Integer> rowsHasToBeRemoved, Set<Integer> columnsHasToBeRemoved) {
        int[][] resultMatrix = new int[matrix.length - rowsHasToBeRemoved.size()][matrix.length - columnsHasToBeRemoved.size()];
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            int col = 0;
            if (!rowsHasToBeRemoved.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    if (!columnsHasToBeRemoved.contains(j)) {
                        resultMatrix[row][col++] = matrix[i][j];
                    }
                }
                row++;
            }
        }
        return resultMatrix;
    }

    private static int maximum(int[][] matrix) {
        int maximum = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > maximum) {
                    maximum = element;
                }
            }
        }
        return maximum;
    }
}
