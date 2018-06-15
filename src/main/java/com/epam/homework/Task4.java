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
        try (Scanner sc = new Scanner(System.in)) {
            int wordsCount = Integer.valueOf(sc.nextLine());

            String wordWithMinimalNumDiffLetters = sc.next();
            int minimalNumDiffLetters = getUniqueLettersCount(wordWithMinimalNumDiffLetters);

            for (int i = 0; i < wordsCount - 1; i++) {
                String word = sc.next();
                int uniqueLettersCount = getUniqueLettersCount(word);

                if (uniqueLettersCount < minimalNumDiffLetters) {
                    minimalNumDiffLetters = uniqueLettersCount;
                    wordWithMinimalNumDiffLetters = word;
                }
            }
            System.out.println(wordWithMinimalNumDiffLetters);
        }
    }

    private static int getUniqueLettersCount(String word) {
        Set<Character> uniqueLetters = new HashSet<>();

        for (char letter: word.toCharArray()) {
            uniqueLetters.add(letter);
        }

        return uniqueLetters.size();
    }
}
