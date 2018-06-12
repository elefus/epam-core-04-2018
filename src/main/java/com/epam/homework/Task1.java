package com.epam.homework;

import java.util.Scanner;

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

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;

        String minString = "";
        String maxString = "";

        Scanner scanner = new Scanner(System.in);
        int numOfStrings = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfStrings; i++) {
            String currentString = scanner.nextLine();
            if (currentString.length() >= maxLength) {
                maxLength = currentString.length();
                maxString = currentString;
            }
            if (currentString.length() <= minLength) {
                minLength = currentString.length();
                minString = currentString;
            }
        }

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);

    }
}