package com.epam.homework;

import java.util.Scanner;

public class Task10 {

    /**
     * Ввести число с консоли.
     * С помощью битовых, логических и арифметических операций определить, является ли указанное значение степенью двойки.
     *
     * Формат входных данных:
     * value - целое число (Integer.MIN_VALUE <= value <= Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * YES - число является степенью двойки
     * NO - число не является степенью двойки
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * -128
     *
     * Выходные данные:
     * NO
     *
     *
     * Входные данные:
     * 256
     *
     * Выходные данные:
     * YES
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        System.out.println(squareRoot(value) == 2 ? "YES" : "NO");
    }

    private static int squareRoot(int value){
        return (value > 2 && value % 2 == 0) ? squareRoot(value >> 1) : value;
    }
}
