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
        try (Scanner in = new Scanner(System.in)) {
            Matrix matrix = Matrix.readMatrix(in);
            Matrix newMatrix = matrix.removeRowsAndColumnsWithMaxElement();
            newMatrix.printMatrix();
        }
    }
}

class Matrix {
    private final int rowsCount;
    private final int columnsCount;
    private final int[][] data;

    public Matrix(int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        data = new int[rowsCount][columnsCount];
    }

    public static Matrix readMatrix (Scanner scanner) {

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

    public int getMaxElement() {
        int maxElement = data[0][0];
        for(int[] row : data) {
            for (int currentElement : row) {
                if (currentElement > maxElement) {
                    maxElement = currentElement;
                }
            }
        }
        return maxElement;
    }

    public Matrix removeRowsAndColumnsWithMaxElement() {

        int maxElement = getMaxElement();
        Set<Integer> rowsToRemove = new HashSet<>(rowsCount);
        Set<Integer> columnsToRemove = new HashSet<>(columnsCount);

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                if (data[i][j] == maxElement) {
                    rowsToRemove.add(i);
                    columnsToRemove.add(j);
                }
            }
        }

        Matrix newMatrix = new Matrix(rowsCount - rowsToRemove.size(),
                columnsCount - columnsToRemove.size());

        int iInOldMatrix = 0;
        for (int i = 0; i < newMatrix.rowsCount; i++) {
            while (rowsToRemove.contains(iInOldMatrix)) {
                iInOldMatrix++;
            }
            int jInOldMatrix = 0;
            for (int j = 0; j < newMatrix.columnsCount; j++) {
                while (columnsToRemove.contains(jInOldMatrix)) {
                    jInOldMatrix++;
                }
                newMatrix.data[i][j] = data[iInOldMatrix][jInOldMatrix++];
            }
            iInOldMatrix++;
        }
        return newMatrix;
    }
}
