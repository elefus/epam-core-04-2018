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
        int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];

        for (int i = 0; i < N; i++) InputArr[i] = String.valueOf(scanner.nextLine());

        Arrays.sort( InputArr, Task2::compare );

        for(String current : InputArr){
            System.out.println("(" + current.length() + "): " + current);

        }
    }
      //  foreach($current : $result) {
     //   System.out.println("(" + current.length() + "): " + current);
      private static int compare(String s1, String s2) {
          if (s1.length() == s2.length())
              return s1.compareTo(s2);
          return Integer.compare(s1.length(), s2.length());
      }
}
