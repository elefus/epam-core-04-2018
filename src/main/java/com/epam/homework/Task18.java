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

    static int max = Integer.MIN_VALUE;
    static HashSet<Integer> rowList = new HashSet<>();
    static HashSet<Integer> colList = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrixAndSearchMax(scanner);
        int[][] newMatrix = removeRowColWithMax(matrix, max);
        writeMatrix(newMatrix);
    }

    private static int[][] readMatrixAndSearchMax(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                    rowList.clear();
                    colList.clear();
                    rowList.add(row);
                    colList.add(col);
                } else if (matrix[row][col] == max) {
                    rowList.add(row);
                    colList.add(col);
                }
            }
        }
        return matrix;
    }

    private static int[][] removeRowColWithMax(int[][] matrix, int max){
        int[][] newMatrix = new int[matrix.length - rowList.size()][matrix.length - colList.size()];
        int countRow = 0;
        int countCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (!rowList.contains(row)){
                for (int col = 0; col < matrix.length; col++) {
                    if (!colList.contains(col)){
                        newMatrix[countRow][countCol++] = matrix[row][col];
                    }
                }
                countRow++;
                countCol = 0;
            }
        }
        return newMatrix;
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
