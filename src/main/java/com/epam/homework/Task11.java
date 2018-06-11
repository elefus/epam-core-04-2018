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

    public static int addUpDigitsInNumber(int number) {
        return recursiveAddUpDigitsInNumber(Math.abs(number));
    }

    private static int recursiveAddUpDigitsInNumber(int number) {
        return (number == 0) ? 0 : number % 10 + recursiveAddUpDigitsInNumber(number / 10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int value = in.nextInt();
        int sum = addUpDigitsInNumber(value);

        System.out.println(sum);
    }
}
