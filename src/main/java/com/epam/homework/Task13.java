package com.epam.homework;

import com.akalji.matrix.*;

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
        Scanner in = new Scanner(System.in);
        Matrix A = new Matrix(in);
        int offset = Integer.parseInt(in.next());
        if (offset==0){
            printMatrix(A);
        }else {
            if (offset>0){
                for (int i = 0; i < Math.abs(offset); i++) {
                    A.shiftDown();
                }
                printMatrix(A);
            }
            if (offset<0){
                for (int i = 0; i < Math.abs(offset); i++) {
                    A.shiftUp();
                }
                printMatrix(A);
            }
        }
    }

    private static void printMatrix(Matrix a) {
        System.out.print(a.getHsize());
        System.out.print(System.lineSeparator());
        for (int i = 0; i< a.getVsize(); i++){
            for (int j = 0; j < a.getHsize(); j++) {
                System.out.printf("%.0f", a.getElement(i, j));
                if (j< a.getHsize()-1){
                    System.out.print(" ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
