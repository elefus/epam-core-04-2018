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
        int N;
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        in.nextLine();

        String minString = in.nextLine();
        int minLength = minString.length();

        String maxString = minString;
        int maxLength = minLength;

        String enteredString;

        for (int i = 1; i < N; i++) {
            enteredString = in.nextLine();

            if (enteredString.length() <= minLength) {
                minString = enteredString;
                minLength = minString.length();
            }

            if (enteredString.length() >= maxLength) {
                maxString = enteredString;
                maxLength = maxString.length();
            }
        }

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }
}
