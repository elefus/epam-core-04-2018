package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  1
     *  2
     *  4
     *  2  4 -2 -3
     *  0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     *
     * Выходные данные:
     *  4
     *  0  1 -1  3
     *  2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());
        int N = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[N][N];
        for (int i = 0; i<N; i++) {
            String[] array = reader.readLine().trim().split(" ");
            for (int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }


        int min = findMIN(matrix,N);
        for (int i = 0; i<N; i++) {

            int q = matrix[i][minColumn];
            matrix[i][minColumn] = matrix[i][Y];
            matrix[i][Y] = q;

        }

        for (int i = 0; i<N; i++) {

            int q = matrix[minRow][i];
            matrix[minRow][i] = matrix[X][i];
            matrix[X][i] = q;

        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }

    static int minColumn;
    static int minRow;

    private static int findMIN(int[][] matrix, int N){
        int min = matrix[0][0];

        for (int i = 0; i<N; i++) {

            for (int j = 0; j<N; j++){
                if (min > matrix[i][j]){
                    min = matrix[i][j];
                    minColumn = j;
                    minRow = i;
                }
            }
        }
        return min;
    }



}