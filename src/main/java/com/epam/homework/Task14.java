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
        try (Scanner in = new Scanner(System.in)) {
            int[] sequence = readSequence(in);
            System.out.println(countElementsOfMaxIncreasingSubsequence(sequence));
        }
    }

    private static int[] readSequence(Scanner scanner) {
        int sequenceSize = scanner.nextInt();
        int[] sequence = new int[sequenceSize];
        for (int i = 0; i < sequenceSize; i++) {
            sequence[i] = scanner.nextInt();
        }
        return sequence;
    }

    private static int countElementsOfMaxIncreasingSubsequence(int[] sequence) {
        int result = 1;
        int count = 1;
        int previous = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] > previous) {
                count++;
            } else {
                count = 1;
            }
            previous = sequence[i];
            result = count > result ? count : result;
        }
        return result > 1 ? result : 0;
    }
}
