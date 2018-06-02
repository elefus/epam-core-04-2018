package com.epam.homework;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matrix matrix = new Matrix(in.nextInt());
        matrix.setMatrix(in);
        System.out.println(matrix.calculateMatrixDeterminant(matrix));
    }
}
