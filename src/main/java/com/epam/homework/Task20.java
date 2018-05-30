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
//            int lineNum = reader.nextInt();
//            int colNum = reader.nextInt();
            int n = reader.nextInt();
            int[][] matrix = getMatrix(n, reader);
            Coord minCoord = getMin(matrix);
            matrix = modifyMatrix(newCoord, minCoord, matrix);
            printMatrix(matrix);
        }
    }

    private static int[][] modifyMatrix(Coord newCoord, Coord oldCoord, int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        fillOldCol(newCoord, oldCoord, matrix,result);
        fillOldRow(newCoord, oldCoord, matrix,result);
        for (int i = 0, newi = 0; i < size && newi < size;) {
            if (oldCoord.getI() == newi) {
                newi++;
                continue;
            }
            if (newCoord.getI() == i) {
                i++;
                continue;
            }
            for (int j = 0, newj = 0; j < size && newj < size;) {
                if (oldCoord.getJ() == newj) {
                    newj++;
                    continue;
                }
                if (newCoord.getJ() == j) {
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
        return result;
    }

    private static void fillOldRow(Coord newCoord, Coord oldCoord, int[][] matrix, int[][] result) {
        int size = matrix.length;
        for (int i = 0, newi = 0; i < size && newi < size;) {
            if(oldCoord.getI() == newi) {
                result[newi][oldCoord.getJ()] = matrix[newCoord.getI()][newCoord.getJ()];
                newi++;
                continue;
            }
            if(newCoord.getI() == i) {
                i++;
                continue;
            }
            result[newi++][oldCoord.getJ()] = matrix[i++][newCoord.getJ()];
        }
    }

    private static void fillOldCol(Coord newCoord, Coord oldCoord, int[][] matrix, int[][] result) {
        int size = matrix.length;
        for (int j = 0, newj = 0; j < size && newj < size;) {
            if(newCoord.getJ() == newj) {
                result[oldCoord.getI()][newj] = matrix[newCoord.getI()][oldCoord.getJ()];
                newj++;
                continue;
            }
            result[oldCoord.getI()][newj++] = matrix[newCoord.getI()][j++];
        }
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
