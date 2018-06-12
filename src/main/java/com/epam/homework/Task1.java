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
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int count = 0;
        int minLength = Integer.MIN_VALUE;
        int maxLength = 0;
        String maxString = null;
        String minString = null;

        try {
            int numberSentences = Integer.valueOf(reader.readLine());
            while (count < numberSentences) {
                line = reader.readLine();
                if (line.length() >= maxLength) {
                    maxString = line;
                    maxLength = line.length();
                }
                if (line.length() <= minLength && line.length() != 0) {
                    minLength = line.length();
                    minString = line;
                } else {
                    minLength = 0;
                    minString = "0";
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }
}
