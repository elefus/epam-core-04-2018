package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
5
Тихо струится река серебристая
В царстве вечернем зеленой весны.
Солнце садится за горы лесистые.
Солнце садится за горы лесистыа.
Рог золотой выплывает луны.
     *
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    public static void main(String[] args) {
        // TODO реализация
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            List<String> lines = new ArrayList<>();
            int lineNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < lineNum; i++) {
                lines.add(br.readLine());
            }
            lines.stream()
                    .sorted(Comparator.comparing(String::length)
                                    .thenComparing(String::compareTo))
                    .forEach(current -> System.out.println("(" + current.length() + "): " + current));
        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
        // TODO foreach($current : $result) {
        // TODO     "(" + current.length() + "): " + current;
        // TODO }
    }
}
