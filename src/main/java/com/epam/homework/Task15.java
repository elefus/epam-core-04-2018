package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task15 {

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     *  3
     *  1   0   3
     * -1   2   2
     *  1  -1   3
     *
     * Выходные данные:
     * -1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i<N; i++) {
            String[] array = reader.readLine().trim().split(" ");
            for (int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }

        int ans = 0;

        for (int i = 0; i<N; i++) {
            boolean foundFirst = false;
            boolean foundSecond = false;
            int rowAns = 0;
            for (int j = 0; j<N; j++) {
                boolean found = false;
                if ((matrix[i][j] > 0) && (!foundFirst)){
                    found = true;
                    foundFirst = true;
                }else{
                    if ((matrix[i][j] > 0) && (!foundSecond) && (foundFirst)){
                        found = true;
                        foundSecond = true;
                    }
                }
                if (!found && foundFirst && !foundSecond){
                    rowAns+=matrix[i][j];
                }

            }
            if (foundFirst && foundSecond) {
                ans += rowAns;
            }
        }
        System.out.println(ans);
    }


}