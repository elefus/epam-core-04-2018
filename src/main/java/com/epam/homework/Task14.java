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

        try (Scanner in = new Scanner(System.in)) {

            int numCount = in.nextInt();
            int[] numbers = new int[numCount];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println(getMaxLenOfAscendingSequence(numbers));

        }
    }

    static int getMaxLenOfAscendingSequence(int[] numbers) {

        int maxLenOfAscendingSequence = 1;
        int currentLenOfAscendingSequence = 1;

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > numbers[i - 1]) {
                currentLenOfAscendingSequence++;
            } else {
                if (currentLenOfAscendingSequence > maxLenOfAscendingSequence) {
                    maxLenOfAscendingSequence = currentLenOfAscendingSequence;
                    currentLenOfAscendingSequence = 1;
                }
            }
        }

        maxLenOfAscendingSequence = Math.max(maxLenOfAscendingSequence, currentLenOfAscendingSequence);

        return (maxLenOfAscendingSequence == 1) ? 0 : maxLenOfAscendingSequence;
    }
}
