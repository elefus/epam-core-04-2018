package com.epam.homework;

import java.util.Scanner;

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
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int n = reader.nextInt();
            int maxLen = 0;
            int curLen = 0;
            int prevDigit = 0;
            int digit = 0;
            for (int i = 0; i < n; i++) {
                digit = reader.nextInt();
                if (digit > 0 && digit > prevDigit) {
                    curLen++;
                    prevDigit = digit;
                } else {
                    prevDigit = 0;
                    curLen = digit > 0 ? 1 : 0;
                }
                maxLen = Math.max(maxLen, curLen);
            }
            System.out.println(maxLen);
        }
    }
}
