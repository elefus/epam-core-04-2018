package com.epam.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

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
1
2
4
2  4 -2 -3
0  1  3 -1
-1  0  2  3
-2  1 -1  4

     4
     4
     5
     2  4 -2 -3 1
     0  1  3 -1 1
     -1  0  2  3 1
     -2  1 -1  -7 1
     1 2 3 4 5

     0
     0
     1
     1

     0
     0
     2
     2  4
     0  -4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            Coord newCoord = new Coord(reader.nextInt(), reader.nextInt());
            int size = reader.nextInt();
            int[][] matrix = getMatrix(size, reader);
            Coord minCoord = getMin(matrix);
            matrix = modifyMatrix(newCoord, minCoord, matrix);
            printMatrix(matrix);
        }
    }

    private static int[][] modifyMatrix(Coord newCoord, Coord oldCoord, int[][] matrix) {
        int size = matrix.length;
        int[][] result = getTemplateMatrixFilledWithNewRowAndCol(newCoord, oldCoord, matrix);
        fillMatrixWithOtherRowsAndCols(newCoord, oldCoord, matrix, size, result);
        return result;
    }

    private static void fillMatrixWithOtherRowsAndCols(Coord newCoord, Coord oldCoord, int[][] matrix, int size, int[][] result) {
        for (int i = 0, newi = 0; i < size && newi < size;) {
            if (newCoord.getI() == newi) {
                newi++;
                continue;
            }
            if (oldCoord.getI() == i) {
                i++;
                continue;
            }
            for (int j = 0, newj = 0; j < size && newj < size;) {
                if (newCoord.getJ() == newj) {
                    newj++;
                    continue;
                }
                if (oldCoord.getJ() == j) {
                    j++;
                    continue;
                }
                result[newi][newj] = matrix[i][j];
                newj++;
                j++;
            }
            newi++;
            i++;
        }
    }

    private static int[][] getTemplateMatrixFilledWithNewRowAndCol(Coord newCoord, Coord oldCoord, int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        int[] newCol = fillNewCol(newCoord, oldCoord, matrix);
        int[] newRow = fillNewRow(newCoord, oldCoord, matrix);
        result[newCoord.getI()] = newRow;
        for (int i = 0; i < matrix.length; i++) {
            result[i][newCoord.getJ()] = newCol[i];
        }
        return result;
    }

    private static int[] fillNewCol(Coord newCoord, Coord oldCoord, int[][] matrix) {
        int size = matrix.length;
        int[] result = new int[size];
        for (int k = 0, newk = 0; k < size || newk < size;) {
            if (k == newCoord.getI()) {
                result[k++] = matrix[oldCoord.getI()][oldCoord.getJ()];
                continue;
            }
            if (newk == oldCoord.getI()) {
                newk++;
                continue;
            }
            result[k++] = matrix[newk++][oldCoord.getJ()];
        }
        return result;
    }

    private static int[] fillNewRow(Coord newCoord, Coord oldCoord, int[][] matrix) {
        int size = matrix.length;
        int[] result = new int[size];
        for (int k = 0, newk = 0; k < size || newk < size;) {
            if (k == newCoord.getJ()) {
                result[k++] = matrix[oldCoord.getI()][oldCoord.getJ()];
                continue;
            }
            if (newk == oldCoord.getJ()) {
                newk++;
                continue;
            }
            result[k++] = matrix[oldCoord.getI()][newk++];
        }
        return result;
    }


    private static Coord getMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        Coord minCoord = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    minCoord = new Coord(i, j);
                }
            }
        }
        return minCoord;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Coord {
        private int i;
        private int j;
    }


    public static int[][] getMatrix(int n, Scanner reader) {
        int[][] matrix  = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
