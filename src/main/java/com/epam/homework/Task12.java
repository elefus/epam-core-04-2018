package com.epam.homework;

import java.util.Scanner;

public class Task12 {

    /**
     * Ввести матрицу с консоли.
     * Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
     * При совпадении значений элементов - строки матрицы должны сохранить такой же относительный порядок как в исходной матрице.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k < N)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * 0    2    3    4    5
     * 1    3    0    2   -1
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 2
     * <p>
     * Выходные данные:
     * 5
     * 7   -1   -5    5    0
     * 5    4   -4   -2    2
     * 1    3   -3   -4    3
     * 1    3    0    2   -1
     * 0    2    3    4    5
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeMat = in.nextInt();
        Matrix myMatrix = new Matrix(sizeMat);
        myMatrix.setMatrix(in);

        int numberOfColumn = in.nextInt();
        myMatrix.sortMatrixInTheOrderOfTheKthColumn(numberOfColumn);

        myMatrix.printMatrix();
    }
}