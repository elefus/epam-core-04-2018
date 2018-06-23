package com.epam.homework;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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
        int dimension = scanner.nextInt();
        readMatrix(scanner, dimension);
    }

    private static void printMatrix(int[][] matrix, int currentRow, int currentColumn) {
        System.out.println(currentRow);
        System.out.println(currentColumn);
        for (int row = 0; row < currentRow; ++row) {
            for (int col = 0; col < currentColumn; ++col) {
                System.out.printf("%12d", matrix[row][col]);
            }
            System.out.println("\n");
        }
    }

    private static void readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        Set<Integer> rows = new HashSet<>();
        Set<Integer> specificColumns = new HashSet<>();
        for (int i = 0; i < dimension; i++) {
            specificColumns.add(i);
        }
        int zeroColumns = 0;
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
                if (matrix[row][col] == 0) {
                    zeroColumns++;
                    if (zeroColumns == dimension) {
                        rows.add(row);
                    }
                } else {
                    specificColumns.remove(col);
                }
            }
            zeroColumns = 0;
        }
        Set<Integer> columns = new HashSet<>(specificColumns);
        deleteZeros(matrix, rows, columns);
    }

    private static void deleteZeros(int[][] matrix, Set<Integer> rows, Set<Integer> columns) {
        int newColumnsLength = matrix.length - columns.size();
        int newRowsLength = matrix.length - rows.size();
        int[][] newMatrix = new int[newRowsLength][newColumnsLength];

        for (int row = 0, newRow = 0; row < matrix.length; row++, newRow++) {

            if (rows.contains(row)) {
                newRow--;
                continue;
            }
            for (int col = 0, newCol = 0; col < matrix.length; col++, newCol++) {

                if (columns.contains(col)) {
                    newCol--;
                    continue;
                }
                newMatrix[newRow][newCol] = matrix[row][col];
            }
        }
        printMatrix(newMatrix, newRowsLength, newColumnsLength);
    }
}
