package com.epam.homework;

import java.util.HashMap;
import java.util.Scanner;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  4
     *  2  0  0 -1
     *  0  0  0  0
     *  0  0  0  3
     * -3  0  0  1
     *
     * Выходные данные:
     *  3
     *  2
     *  2 -1
     *  0  3
     * -3  1
     */

    private static HashMap<Integer, Integer> rowMap = new HashMap<>();
    private static HashMap<Integer, Integer> colMap = new HashMap<>();
    private static int countZeroRow;
    private static int countZeroCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrixAndSearchZero(scanner);
        int[][] newMatrix = removeZeroRowCol(matrix);
        writeMatrix(newMatrix);
    }

    private static int[][] readMatrixAndSearchZero(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            rowMap.put(row, 0);
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();

                if (row == 0){
                    colMap.put(col, 0);
                }
                if (matrix[row][col] == 0) {
                    rowMap.put(row, rowMap.get(row) + 1);
                    colMap.put(col, colMap.get(col) + 1);
                }
                if (row == dimension - 1){
                    countZeroCol = colMap.get(col) == dimension ? ++countZeroCol : countZeroCol;
                }
            }
            countZeroRow = rowMap.get(row) == dimension ? ++countZeroRow : countZeroRow;
        }
        return matrix;
    }

    private static int[][] removeZeroRowCol(int[][] matrix){
        int[][] newMatrix = new int[matrix.length - countZeroRow][matrix.length - countZeroCol];
        int countRow = 0;
        int countCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (!(rowMap.get(row) == matrix.length)){
                for (int col = 0; col < matrix.length; col++) {
                    if (!(colMap.get(col) == matrix.length)){
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
