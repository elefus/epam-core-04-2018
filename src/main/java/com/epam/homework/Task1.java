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
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String minString = "";
            String maxString = "";
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            int lineNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < lineNum; i++){
                String line = br.readLine();
                if (line.length() >= maxLength) {
                    maxLength = line.length();
                    maxString = line;
                }
                if (line.length() <= minLength) {
                    minLength = line.length();
                    minString = line;
                }
            }
            System.out.println("MIN (" + minLength + "): " + minString);
            System.out.println("MAX (" + maxLength + "): " + maxString);
        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }
}
