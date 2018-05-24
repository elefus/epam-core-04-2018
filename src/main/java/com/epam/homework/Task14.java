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

    public static int lengthOfLongestAscendingSequence(int[] numbers) {
        int lengthOfCurrentAscendingSequence = 0;
        int lengthOfLongestAscendingSequence = lengthOfCurrentAscendingSequence;

        for (int i = 0; i < numbers.length - 1; i++) {

            if (numbers[i] >= numbers[i + 1]) {
                if (lengthOfCurrentAscendingSequence > lengthOfLongestAscendingSequence) {
                    lengthOfLongestAscendingSequence = lengthOfCurrentAscendingSequence;
                }
                lengthOfCurrentAscendingSequence = 0;
            } else {
                lengthOfCurrentAscendingSequence += (lengthOfCurrentAscendingSequence == 0) ? 2 : 1;
            }
        }

        return lengthOfLongestAscendingSequence;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] numbers = new int[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println(lengthOfLongestAscendingSequence(numbers));
        }
    }
}
