package com.epam.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Task1 {

    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     *
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     *
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     *
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */

    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        strings.add(reader.readLine());

        String maxString = strings.get(0);
        String minString = maxString;

        for (int i = 1; i < n; i++) {
            strings.add(reader.readLine());
            if (strings.get(i).length() <= minString.length()) {
                minString = strings.get(i);
            }
            if (strings.get(i).length() >= maxString.length()) {
                maxString = strings.get(i);
            }
        }

        System.out.println("MIN (" + minString.length() + "): " + minString);
        System.out.println("MAX (" + maxString.length() + "): " + maxString);
    }
}
