package com.epam.homework;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int[] seq = new int[value];
        for (int i = 0; i < value; i++) {
            seq[i] = scanner.nextInt();
        }
        System.out.println(lengthOfNessensarySeqiense(seq));
    }

    public static int lengthOfNessensarySeqiense(int[] seq) {
        int sequenceCounter = 1;
        int max = 0;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] > seq[i - 1]) {
                if (++sequenceCounter > max) {
                    max = sequenceCounter;
                }
            } else {
                sequenceCounter = 1;
            }
        }
        return max;
    }
}

