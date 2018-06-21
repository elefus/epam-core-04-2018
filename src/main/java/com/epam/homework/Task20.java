package com.epam.homework;

import java.util.Scanner;
import com.kindet27.matrix.*;

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
     *  1
     *  2
     *  4
     *  2  4 -2 -3
     *  0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetRow = scanner.nextInt();
        int targetColumn = scanner.nextInt();
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);

        int minElRow = -1;
        int minElColumn = -1;
        Integer minEl = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if(matrix.getElement(i, j) < minEl) {
                    minEl = matrix.getElement(i, j);
                    minElRow = i;
                    minElColumn = j;
                }
            }
        }

        matrix.swapTwoRows(minElRow, targetRow);
        matrix.swapTwoColumns(minElColumn, targetColumn);
        matrix.matrixSout();
    }
}
