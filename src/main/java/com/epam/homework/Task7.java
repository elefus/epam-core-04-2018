package com.epam.homework;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов (состоящих только из букв английского языка), разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     * <p>
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            int wordCount = Integer.valueOf(in.next());
            Set<String> result = new LinkedHashSet<>();

            for (int i = 0; i < wordCount; i++) {

                String word = in.next().toLowerCase();
                if (containsOnlyEnglishLetters(word) && containsOnlyUniqueChars(word)) {
                    result.add(word);
                }
            }

            if (result.isEmpty()) {
                System.out.println("NOT FOUND");
            } else {
                StringBuilder sb = new StringBuilder();

                for (String word : result) {
                    if (sb.length() != 0) {
                        sb.append(' ');
                    }
                    sb.append(word);
                }

                System.out.println(sb);
            }
        }
    }

    private static final Pattern ENGLISH_LETTERS = Pattern.compile("^[A-Za-z]+$");

    private static boolean containsOnlyUniqueChars(String word) {
        return word.chars().distinct().count() == word.length();
    }

    private static boolean containsOnlyEnglishLetters(String word) {
        Matcher matcher = ENGLISH_LETTERS.matcher(word);
        return matcher.matches();
    }
}
