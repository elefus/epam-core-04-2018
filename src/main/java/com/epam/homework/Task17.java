package com.epam.homework;

import com.kindet27.matrix.*;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     * -2  1  2
     *  0 -1  0
     *  1 -2  3
     *
     * Выходные данные:
     * 8
     *
     *
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     *
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);
        System.out.println(matrix.calculateDeterminant());
    }
}
