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
     * summary - сумма цифр, составляющих исходное число
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
        Scanner in = new Scanner(System.in);

        int value = in.nextInt();
        int summary = addUpDigits(value);

        System.out.println(summary);
    }

    public static int addUpDigits(int number) {
        return recursiveSummDigits(Math.abs(number));
    }

    public static int recursiveSummDigits(int number) {
        return (number == 0) ? 0 : number % 10 + recursiveSummDigits(number / 10);
    }
}

