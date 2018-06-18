package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = String.valueOf(Math.abs(Integer.parseInt(reader.readLine())));

        System.out.println(sumOfDigits(number));
    }

    private static int sumOfDigits(String string) {
        return (string.length() > 1)
                ? Integer.parseInt(string.substring(0, 1)) + sumOfDigits(string.substring(1))
                : Integer.parseInt(string);
    }
}
