package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int min = Integer.MAX_VALUE;
        String smallestUnique = "";

        for (int i = 0; i < count; i++) {
            String input = sc.next();
            int diffChars = uniqueChars(input);
            if (diffChars < min) {
                min = diffChars;
                smallestUnique = input;
            }
        }

        System.out.println(smallestUnique);
    }

    private static int uniqueChars(String str) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueLetters.add(str.charAt(i));
        }
        return uniqueLetters.size();
    }
}