package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

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
        try (Scanner in = new Scanner(System.in)) {
            Matrix matrix = Matrix.readSquareMatrix(in);

            for (int i = 0; i < matrix.getRowsCount(); i++) {
                if (matrix.rowContainsOnlyZeros(i)) {
                    matrix.removeRow(i--);
                }
            }

            for (int j = 0; j < matrix.getColumnsCount(); j++) {
                if (matrix.columnContainsOnlyZeros(j)) {
                    matrix.removeColumn(j--);
                }
            }

            matrix.printMatrix();
        }
    }
}

class Matrix {

    public void setData(int[][] data) {
        this.data = data;
    }

    private int rowsCount;
    private int columnsCount;
    private int[][] data;

    public Matrix(int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        data = new int[rowsCount][columnsCount];
    }

    public static Matrix readSquareMatrix(Scanner scanner) {

        int rowsCount = scanner.nextInt();
        int columnsCount = rowsCount;

        Matrix matrix = new Matrix(rowsCount, columnsCount);

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                matrix.data[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public void printMatrix() {
        System.out.println(rowsCount);
        System.out.println(columnsCount);
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void removeRow(int indexToRemove) {
        int[][] newData = new int[rowsCount - 1][columnsCount];
        for (int i = 0; i < rowsCount - 1; i++) {
            if (i < indexToRemove) {
                newData[i] = Arrays.copyOf(data[i], data[i].length);
            } else {
                newData[i] = Arrays.copyOf(data[i + 1], data[i].length);
            }
        }
        data = newData;
        rowsCount--;
    }

    public void removeColumn(int indexToRemove) {
        int[][] newData = new int[rowsCount][columnsCount - 1];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount - 1; j++) {
                if (j < indexToRemove) {
                    newData[i][j] = data[i][j];
                } else {
                    newData[i][j] = data[i][j + 1];
                }
            }
        }
        data = newData;
        columnsCount--;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public boolean rowContainsOnlyZeros(int rowIndex) {
        for (int j = 0; j < columnsCount; j++) {
            if (data[rowIndex][j] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean columnContainsOnlyZeros(int columnIndex) {
        for (int i = 0; i < rowsCount; i++) {
            if (data[i][columnIndex] != 0) {
                return false;
            }
        }
        return true;
    }
}

