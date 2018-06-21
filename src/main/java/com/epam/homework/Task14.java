package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task14 {

    /**
     * Найти количество элементов самой длинной строго возрастающей подпоследовательности.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * <a href="https://ru.wikipedia.org/wiki/Монотонная_последовательность">Строго возрастающая последовательность</a>
     *
     * Формат входных данных:
     * N (целое число) - количество элементов исходной последовательности (0 < N < 100).
     * N целых чисел - элементы последовательности.
     *
     * Формат выходных данных:
     * Число, отображающее количество элементов на самом большом возрастающем участке последовательности.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 8
     * 2 1 3 3 4 5 6 5
     *
     * Выходные данные:
     * 4
     *
     *
     *
     * Входные данные:
     * 6
     * 6 5 4 3 2 1
     *
     * Выходные данные:
     * 0
     */

    static int order = 1;

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N];
        String[] array = reader.readLine().trim().split(" ");
        for (int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(array[i]);
        }

        int ans = 0;
        int countOfRow = 0;
        if (N>1) {
            for (int i = 0; i < N-1; i++) {
                if (numbers[i] < numbers[i+1]){
                    countOfRow++;
                }else
                {
                    if (countOfRow+1>ans){
                        ans = countOfRow+1;
                    }
                    countOfRow = 0;
                }
            }
        }
        System.out.println(ans);
    }


}
