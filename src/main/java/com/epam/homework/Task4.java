package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());

        String wordWithMinimalNumDiffLetters = "";
        int minimalNumDiffLetters = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            String string = scanner.next();
            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                hashSet.add(string.charAt(i));
            }
            if (hashSet.size() < minimalNumDiffLetters) {
                wordWithMinimalNumDiffLetters = string;
                minimalNumDiffLetters = hashSet.size();
            }
        }
        System.out.println(wordWithMinimalNumDiffLetters);
    }
}