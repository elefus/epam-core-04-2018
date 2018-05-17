package com.epam.homework;

import java.util.Arrays;
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
        try (Scanner scanner = new Scanner(System.in)) {
            String digit = scanner.nextLine();
            int[] digitArray = new int[digit.length()];
            for (int i = 0; i < digit.length(); i++) {
                char d = digit.charAt(i);
                if(Character.isDigit(d)) {
                    digitArray[i] = Integer.parseInt(String.valueOf(d));
                }
            }
            System.out.println(new Task11().getSum(digitArray));
        }
    }

    private int sum;
    private int getSum(int[] array) {
        if (array.length == 0) return sum;
        sum+=array[array.length-1];
        return getSum(Arrays.copyOf(array, array.length-1));
    }
}