package com.epam.homework;

import java.util.Arrays;
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
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int maxCount = 1;
        int count = 1;
        int pastValue = -1;
        int currentValue;

        for (int i = 0; i < quantity; i++) {
            currentValue = scanner.nextInt();

            if (i != 0 && currentValue > pastValue){
                if (maxCount < ++count){
                    maxCount = count;
                }
            }
            else {
                count = 1;
            }
            pastValue = currentValue;
        }

        System.out.println(maxCount > 1 ? maxCount : 0);
    }
}
