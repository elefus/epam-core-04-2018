package com.epam.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task2 {

    /**
     * Ввести N строк с консоли.
     * Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должны быть выведены N строк следующего вида:
     * (длина строки): строка наименьшей длины
     * (длина строки): строка большей длины
     * (длина строки): строка большей длины
     * ...
     * (длина строки): строка наибольшей длины
     *
     * ----------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Тихо струится река серебристая
     * В царстве вечернем зеленой весны.
     * Солнце садится за горы лесистые.
     * Рог золотой выплывает луны.
     * 
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    public static void main(String[] args) {

        ArrayList<String> unsorted;

        try (Scanner in = new Scanner(System.in)) {

            int count = Integer.valueOf(in.nextLine());
            unsorted = new ArrayList<>(count);

            for (int i = 0; i < count; i++) {
                unsorted.add(in.nextLine());
            }
        }

        // Step 1. Alphabetizing
        Collections.sort(unsorted);

        // Step 2. Sort by string length

        ArrayList<String> sorted = new ArrayList<>();

        while (!unsorted.isEmpty()) {
            String minString = unsorted.get(0);
            for (String string : unsorted) {
                if (string.length() < minString.length()) {
                    minString = string;
                }
            }
            sorted.add(minString);
            unsorted.remove(minString);
        }

        for (String str : sorted) {
            System.out.println("(" + str.length() + "): " + str);
        }
    }
}
