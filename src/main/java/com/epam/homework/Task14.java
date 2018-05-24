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
        int numbOfDigits = in.nextInt();

        int[] inputSequence = new int[numbOfDigits];

        for (int i = 0; i < numbOfDigits; i++) {
            inputSequence[i] = in.nextInt();
        }

        System.out.println(getLengthOfAscendingSequence(inputSequence));
    }

    private static int getLengthOfAscendingSequence(int[] arr) {
        if (arr.length < 2)
            return 0;

        int maxLength = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            } else if (count > maxLength) {
                maxLength = count;
                count = 1;
            }
        }

        return (maxLength > 1) ? maxLength: 0;
    }
}
