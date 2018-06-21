package com.epam.homework;
import java.util.Arrays;
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
        String minString = "";
        String maxString = "";
        int minLength = 0;
        int maxLength = 0;

        int stringAmount = Integer.parseInt(scanner.nextLine());
        String stringArray[] = new String[stringAmount];

        for (int i = 0; i < stringAmount; ++i) {
            stringArray[i]=scanner.nextLine();
        }


        Arrays.sort(stringArray, (i1, i2) -> i1.length() == i2.length() ? i1.compareTo(i2) : Integer.compare(i1.length(), i2.length()));

        for(String current : stringArray) {
                 System.out.println("(" + current.length() + "): " + current);
        }

    }
}
