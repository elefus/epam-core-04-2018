package com.epam.homework;

import java.util.*;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     *
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int wordsCount = Integer.valueOf(reader.nextLine());
            Set<String> uniqueWordsConsistedOfDiffLetters = new LinkedHashSet<>();

            for (int i = 0; i < wordsCount; i++) {
                String nextWord = reader.next();

                if (isConsistedOfDiffLetters(nextWord) &&
                        !uniqueWordsConsistedOfDiffLetters.contains(nextWord.toLowerCase())) {

                    uniqueWordsConsistedOfDiffLetters.add(nextWord);
                }
            }

            if (!uniqueWordsConsistedOfDiffLetters.isEmpty()) {
                System.out.println(String.join(" ", uniqueWordsConsistedOfDiffLetters));
            } else {
                System.out.println("NOT FOUND");
            }
        }
    }

    private static boolean isConsistedOfDiffLetters(String word) {
        return word.length() == getUniqueLetters(word).size();
    }

    private static Set<Character> getUniqueLetters(String word) {
        Set<Character> uniqueLetters = new HashSet<>();

        for (char letter: word.toLowerCase().toCharArray()) {
            uniqueLetters.add(letter);
        }

        return uniqueLetters;
    }
}
