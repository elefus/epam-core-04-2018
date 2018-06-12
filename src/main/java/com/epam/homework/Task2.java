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
        Scanner in = new Scanner(System.in);
        Comparator<String> comparator = new MyStringComparator();
        int strCount =in.nextInt();
        in.nextLine();
        String[] array = new String[strCount];
        for (int i = 0; i < strCount; i++) {
            array[i] = in.nextLine();
        }
        Arrays.parallelSort(array, comparator);

        for(String current : array) {
        System.out.println("(" + current.length() + "): " + current);
        }
    }

    public static class MyStringComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()) {
                return 1;
            }

            if(o1.length() < o2.length()) {
                    return -1;
            }

            if(o1.equals(o2)) {
                return 0;
            }

            return o1.compareTo(o2);

        }
    }

}
