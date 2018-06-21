package com.epam.homework;

import java.util.Scanner;

public class Task11 {

    /**
     * Ввести число с консоли.
     * С использованием рекурсии вычислить сумму цифр, из которых составлено указанное число.
     * <p>
     * Формат входных данных:
     * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
     * <p>
     * Формат выходных данных:
     * sum - сумма цифр, составляющих исходное число
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 25593
     * <p>
     * Выходные данные:
     * 24
     * <p>
     * <p>
     * Входные данные:
     * -50
     * <p>
     * Выходные данные:
     * 5
     */
    public static void main(String[] args) {
        // TODO реализация
        int sum = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            String value = scanner.nextLine();
            int[] valueArray = new int[value.length()];
            for (int i = 0; i < value.length(); i++) {
                char d = value.charAt(i);
                if (Character.isDigit(d)) {
                    sum += Integer.parseInt(String.valueOf(d));
                }
            }
            System.out.println(sum);
        }
    }

}


