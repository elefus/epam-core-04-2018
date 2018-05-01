package com.epam.homework;

import java.util.Arrays;
import java.util.Comparator;
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

        Scanner scanner = new Scanner(System.in);
        Comparator<String> comparator = new LexicalAndLengthComparator();
        int numOfStrings = scanner.nextInt();
        scanner.nextLine();
        String[] arrayOfStrings = new String[numOfStrings];

        for (int i = 0; i < numOfStrings; i++) {
            arrayOfStrings[i] = scanner.nextLine();
        }

        Arrays.sort(arrayOfStrings, comparator);

        for (String current : arrayOfStrings) {
            System.out.println("(" + current.length() + "): " + current);
        }
    }

    private static class LexicalAndLengthComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            if (str1.length() > str2.length()) {
                return 1;
            }

            if (str1.length() < str2.length()) {
                return -1;
            }

            if (str1.equals(str2)) {
                return 0;
            }

            return str1.compareTo(str2);
        }
    }
}



