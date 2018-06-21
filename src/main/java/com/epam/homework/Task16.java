package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     *     ...
     *     case  -5: поворот на 450* против часовой стрелки
     *     case  -4: поворот на 360* против часовой стрелки
     *     case  -3: поворот на 270* против часовой стрелки
     *     case  -2: поворот на 180* против часовой стрелки
     *     case  -1: поворот на  90* против часовой стрелки
     *     case   0: поворот не осуществляется
     *     case   1: поворот на  90* по     часовой стрелке
     *     case   2: поворот на 180* по     часовой стрелке
     *     case   3: поворот на 270* по     часовой стрелке
     *     case   4: поворот на 360* по     часовой стрелке
     *     case   5: поворот на 450* по     часовой стрелке
     *     ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     *  1  -2   1
     * -3   0   2
     *  3  -2   1
     *  1
     *
     * Выходные данные:
     *  3
     *  3  -3   1
     * -2   0  -2
     *  1   2   1
     *
     *
     *
     * Входные данные:
     *  2
     *  9  3
     *  2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
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
        int k = Integer.parseInt(reader.readLine());
        System.out.println(N);
        if (k < 0){
            k = k % 4;
            if (k!=0) {k+=4;}
        }else {k = k % 4;}

        if (k == 0){
            zero(matrix, N);
        }
        if (k == 1){
            one(matrix, N);
        }
        if (k == 2){
            two(matrix, N);
        }
        if (k == 3){
            three(matrix, N);
        }

    }

    private static void zero(int[][] matrix, int N){
        for (int i = 0; i<N; i++) {

            for (int j = 0; j<N; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void one(int[][] matrix, int N){
        for (int i = 0; i<N; i++) {

            for (int j = 0; j<N; j++){
                System.out.print(matrix[N-1-j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void two(int[][] matrix, int N){
        for (int i = 0; i<N; i++) {

            for (int j = 0; j<N; j++){
                System.out.print(matrix[N-1-i][N-1-j] + " ");
            }
            System.out.println();
        }
    }
    private static void three(int[][] matrix, int N){
        for (int i = 0; i<N; i++) {


            for (int j = 0; j<N; j++){
                System.out.print(matrix[j][N-1-i]+ " ");
            }
            System.out.println();
        }
    }
}
