package com.epam.homework;

import com.kindet27.matrix.*;

import java.util.Scanner;

public class Task15 {

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1   0   3
     * -1   2   2
     * 1  -1   3
     * <p>
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix<Integer> matrix = new Matrix<>(scanner, Scanner::nextInt);
        int sum = 0;
        boolean isFirstPositiveFound;
        for (int i = 0; i < matrix.getRows(); i++) {
            isFirstPositiveFound = false;
            int curSum = 0;
            for (int j = 0; j < matrix.getRows(); j++) {
                int cur = matrix.getElement(i, j);
                if (cur > 0) {
                    if (isFirstPositiveFound) {
                        sum += curSum;
                        break;
                    } else {
                        isFirstPositiveFound = true;
                    }
                } else {
                    if (isFirstPositiveFound) {
                        curSum += cur;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
