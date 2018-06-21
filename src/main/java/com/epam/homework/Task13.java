package com.epam.homework;

import com.kindet27.matrix.*;

import java.util.Scanner;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     *
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     *
     *
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     *
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);
        int cycleSize = scanner.nextInt();
        int target = (((cycleSize) % matrix.getRows()) + matrix.getRows()) % matrix.getRows();
        for (int i = 0; i < matrix.getRows() - 1 ; i++) {
           matrix.swapTwoRows(0, target);
           target = (target + cycleSize) % matrix.getRows();
        }
        matrix.matrixSout();
    }
}
