package com.epam.homework;

import com.akalji.genericmatrix.Matrix;

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
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int matrixSize = scanner.nextInt();

        Matrix<Integer> matrix = new Matrix<>(matrixSize);

        int minX = -1;
        int minY = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();
                matrix.set(i, j, value);
                if (value < minValue) {
                    minValue = value;
                    minX = i;
                    minY = j;
                }
            }
        }

        if (minX != X) {
            if (minX > X) {
                for (int i = minX; i > X; i--) {
                    matrix.swapRows(i, i - 1);
                }
            } else {
                for (int i = minX; i < X; i++) {
                    matrix.swapRows(i, i + 1);
                }
            }
        }

        if (minY != Y) {
            if (minY > Y) {
                for (int i = minY; i > Y; i--) {
                    matrix.swapColumns(i, i - 1);
                }
            } else {
                for (int i = minY; i < Y; i++) {
                    matrix.swapColumns(i, i + 1);
                }
            }
        }

        printMatrix(matrix);
    }


    private static void printMatrix(Matrix<Integer> A) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(A.getHsize());
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < A.getVsize(); i++) {
            for (int j = 0; j < A.getHsize(); j++) {
                stringBuilder.append(A.getElement(i, j));
                if (j < A.getHsize() - 1) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder.toString());
    }
}
