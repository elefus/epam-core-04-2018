package com.epam.homework;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            int targetRowIndex = in.nextInt();
            int targetColumnIndex = in.nextInt();

            Matrix matrix = Matrix.readSquareMatrix(in);
            Matrix.Element minElement = matrix.getMinElement();

            matrix.swapRows(targetRowIndex, minElement.getRowIndex());
            matrix.swapColumns(targetColumnIndex, minElement.getColumnIndex());

            System.out.println(matrix);
        }
    }
}

class Matrix {
    
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rowsCount).append('\n');

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                sb.append(data[i][j]).append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public Element getMinElement() {
        Element minElement = new Element(0, 0);
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                if (data[i][j] < minElement.getValue()) {
                    minElement.setValueByIndices(i, j);
                }
            }
        }
        return minElement;
    }

    public void swapRows(int rowIndex1, int rowIndex2) {
        int[] tmpRow = data[rowIndex1];
        data[rowIndex1] = data[rowIndex2];
        data[rowIndex2] = tmpRow;
    }

    public void swapColumns(int columnIndex1, int columnIndex2) {
        for (int i = 0; i < rowsCount; i++) {
            int tmpElement = data[i][columnIndex1];
            data[i][columnIndex1] = data[i][columnIndex2];
            data[i][columnIndex2] = tmpElement;
        }
    }

    public class Element {
        private int rowIndex;
        private int columnIndex;
        private int value;

        public Element(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.value = data[rowIndex][columnIndex];
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getColumnIndex() {
            return columnIndex;
        }

        public int getValue() {
            return value;
        }

        public void setValueByIndices(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.value = data[rowIndex][columnIndex];
        }
    }
}
