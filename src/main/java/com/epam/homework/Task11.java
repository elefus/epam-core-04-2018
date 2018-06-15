package com.epam.homework;

import java.util.Scanner;

public class Task11 {

    /**
     * Ввести число с консоли.
     * С использованием рекурсии вычислить сумму цифр, из которых составлено указанное число.
     *
     * Формат входных данных:
     * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
     *
     * Формат выходных данных:
     * sum - сумма цифр, составляющих исходное число
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 25593
     *
     * Выходные данные:
     * 24
     *
     *
     * Входные данные:
     * -50
     *
     * Выходные данные:
     * 5
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int value = in.nextInt();

            System.out.println(sumOfDigits(value));
        }
    }

    static int sumOfDigits(int value) {
        if (value == 0) {
            return 0;
        }
        return Math.abs(value % 10) + sumOfDigits(value / 10);
    }
}
