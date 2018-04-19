package com.epam.homework;

import java.util.*;

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
        String[] words;

        try (Scanner sc = new Scanner(System.in)) {
            sc.nextLine();
            words = sc.nextLine().trim().split("\\s+");
        }

        int numDiffLetters = 0;
        String wordWithMinimalNumDiffLetters = "";

        for (String word: words) {
            Set<Character> uniqueLetters = new HashSet<>();

            for (char letter: word.toCharArray()) {
                uniqueLetters.add(letter);
            }

            if (uniqueLetters.size() < numDiffLetters || numDiffLetters == 0) {
                numDiffLetters = uniqueLetters.size();
                wordWithMinimalNumDiffLetters = word;
            }
        }

        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
