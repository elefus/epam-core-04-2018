package com.epam.homework;

import java.util.Scanner;

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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];

            int minLength = 0;
            String minString = "";
            int maxLength= 0;
            String maxString = "";
            for (int i = 0; i < N; i++) {
                InputArr[i] = String.valueOf(scanner.nextLine());
                if (i == 0) {
                    minLength = InputArr[0].length();
                    minString = InputArr[0];
                    maxLength = InputArr[0].length();
                    maxString = InputArr[0];
                }
                if (InputArr[i].length() <= minLength) {
                    minLength = InputArr[i].length();
                    minString = InputArr[i];
                }
                if (InputArr[i].length() >= maxLength) {
                    maxLength = InputArr[i].length();
                    maxString = InputArr[i];
                }

            }
            System.out.println("MIN (" + minLength + "): " + minString);
            System.out.println("MAX (" + maxLength + "): " + maxString);




    }
}
