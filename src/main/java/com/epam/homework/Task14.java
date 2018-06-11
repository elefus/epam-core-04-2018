package com.epam.homework;

import java.util.Scanner;

public class Task14 {

    /**
     * Найти количество элементов самой длинной строго возрастающей подпоследовательности.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * <a href="https://ru.wikipedia.org/wiki/Монотонная_последовательность">Строго возрастающая последовательность</a>
     * <p>
     * Формат входных данных:
     * N (целое число) - количество элементов исходной последовательности (0 < N < 100).
     * N целых чисел - элементы последовательности.
     * <p>
     * Формат выходных данных:
     * Число, отображающее количество элементов на самом большом возрастающем участке последовательности.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 8
     * 2 1 3 3 4 5 6 5
     * <p>
     * Выходные данные:
     * 4
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 6
     * 6 5 4 3 2 1
     * <p>
     * Выходные данные:
     * 0
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = in.nextInt();
        int[] arrayNumbers = new int[counter];
        for (int i = 0; i < counter; i++) {
            arrayNumbers[i] = in.nextInt();
        }
        System.out.println(getLongestSubsequence(arrayNumbers));

    }

    private static int getLongestSubsequence(int[] array) {
        int subsequence = 1;
        int maxSubsequence = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                subsequence++;
                if (maxSubsequence < subsequence) {
                    maxSubsequence = subsequence;
                }
            } else {
                subsequence = 1;
            }
        }
        return maxSubsequence;
    }
}