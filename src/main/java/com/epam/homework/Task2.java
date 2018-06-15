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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
         int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];

        for (int i = 0; i < N; i++) InputArr[i] = String.valueOf(scanner.nextLine());
        Comparator<String> comparator = (o1,o2) -> o1.length() - o2.length();


        Arrays.sort(InputArr, comparator); // применяем сортировку
        for(String current : InputArr){
            System.out.println("(" + current.length() + "): " + current);

        }
    }
      //  foreach($current : $result) {
     //   System.out.println("(" + current.length() + "): " + current);

}
