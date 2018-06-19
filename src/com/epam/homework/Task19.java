package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] array = reader.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }


        boolean[] rows = new boolean[N];
        boolean[] colums = new boolean[N];

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (0 != matrix[i][j]) {
                    rows[i] = true;
                    colums[j] = true;
                }
            }

        }

        int n = N;
        int m = N;
        for (int i = 0; i < N; i++) {

            if (!rows[i]) {
                n--;
            }
            if (!colums[i]) {
                m--;
            }

        }
        System.out.println(n);
        System.out.println(m);


        for (int i = 0; i < N; i++) {
            boolean exist = false;
            for (int j = 0; j < N; j++) {
                if (rows[i] && colums[j]) {
                    System.out.print(matrix[i][j] + " ");
                    exist = true;
                }
            }
            if (exist) {
                System.out.println();
            }
        }

    }
}

