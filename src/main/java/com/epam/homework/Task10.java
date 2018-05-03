package com.epam.homework;

import java.util.Scanner;

public class Task10 {

    /**
     * Ввести число с консоли.
     * С помощью битовых, логических и арифметических операций определить, является ли указанное значение степенью двойки.
     * <p>
     * Формат входных данных:
     * value - целое число (Integer.MIN_VALUE <= value <= Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * YES - число является степенью двойки
     * NO - число не является степенью двойки
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * -128
     * <p>
     * Выходные данные:
     * NO
     * <p>
     * <p>
     * Входные данные:
     * 256
     * <p>
     * Выходные данные:
     * YES
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = Integer.parseInt(in.nextLine());
        isPowerOfTwo(value);
    }

    private static void isPowerOfTwo(int value) {
        if (value > 0 && (value & (value - 1)) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
