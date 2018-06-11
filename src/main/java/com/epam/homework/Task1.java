package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     * <p>
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     * <p>
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int indexOfMaxLength = 0;
        int indexOfMinLength = 0;
        String[] s = new String[n];
        for (int i = 0; i < s.length; i++) {
                s[i] = reader.readLine();
            if (s[i].length() <= s[indexOfMinLength].length())
                indexOfMinLength = i;
            if (s[i].length() >= s[indexOfMaxLength].length())
                indexOfMaxLength = i;
        }
        System.out.println("MIN (" + s[indexOfMinLength].length() + "): " + s[indexOfMinLength]);
        System.out.println("MAX (" + s[indexOfMaxLength].length() + "): " + s[indexOfMaxLength]);
    }
}

