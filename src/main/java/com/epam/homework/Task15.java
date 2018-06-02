package com.epam.homework;

import java.util.Scanner;

import com.akalji.genericmatrix.*;

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
        int matrixSize = scanner.nextInt();
        Matrix<Integer> matrix = new Matrix<>(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix.set(i, j, scanner.nextInt());
            }
        }

        int totalSum = 0;
        for (int i = 0; i < matrix.getVsize(); i++) {
            int lineSum = 0;
            boolean isFirst = false;
            boolean isLast = false;
            for (int j = 0; j < matrix.getHsize(); j++) {

                // При достижении второго положительного элемента переходим к следующей строке
                if (isFirst & matrix.getElement(i, j) > 0) {
                    isLast = true;
                    break;
                }

                // При нахождении первого положительного элемента ставим флаг и переходим к следующему элементу
                if (!isFirst & matrix.getElement(i, j) > 0) {
                    isFirst = true;
                    continue;
                }

                if (isFirst) {
                    lineSum += matrix.getElement(i, j);
                }
            }
            if (isFirst) {
                totalSum += lineSum;
            }
        }
        System.out.println(totalSum);
    }
}
