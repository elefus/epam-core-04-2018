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
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        setThePositionsWhereAllValuesAreNull(rows, columns, matrix);

        int[][] shiftedMatrix = getShiftedMatrixWithoutRowsAndColumns(rows, columns, matrix);

        System.out.println(shiftedMatrix.length);
        System.out.println(shiftedMatrix[0].length);
        printMatrix(shiftedMatrix);
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

    private static void setThePositionsWhereAllValuesAreNull(Set<Integer> rows,
                                                             Set<Integer> columns,
                                                             int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    break;
                }
                if (j == matrix.length - 1) {
                    rows.add(i);
                }
            }
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][i] != 0) {
                    break;
                }
                if (k == matrix.length - 1) {
                    columns.add(i);
                }
            }
        }
    }

    private static int[][] getShiftedMatrixWithoutRowsAndColumns(Set<Integer> removingRows,
                                                                 Set<Integer> removingColumns,
                                                                 int[][] oldMatrix) {

        int[][] newMatrix = new int[oldMatrix.length - removingRows.size()][oldMatrix.length - removingColumns.size()];

        int rowsOffset = 0;
        for (int i = 0; i < oldMatrix.length; i++) {
            if (removingRows.contains(i)) {
                rowsOffset++;
            } else {
                int columnsOffset = 0;
                for (int j = 0; j < oldMatrix[0].length; j++) {
                    if (removingColumns.contains(j)) {
                        columnsOffset++;
                    } else {
                        newMatrix[i - rowsOffset][j - columnsOffset] = oldMatrix[i][j];
                    }
                }
            }

        }
        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.printf("%8d", row[i]);
            }
            System.out.println("\n");
        }
    }
}