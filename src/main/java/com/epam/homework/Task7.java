package com.epam.homework;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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
         try (Scanner scaner = new Scanner(System.in)) {
            int number = scaner.nextInt();
            Set<String> foundWords = new LinkedHashSet<>();

            outer:
            for (int i = 0; i < number; i++) {
                String word = scaner.next();

                for (int j = 0; j < word.length() - 1; j++) {
                    String lowerCaseWord = word.toLowerCase();

                    if (lowerCaseWord.indexOf(lowerCaseWord.charAt(j), j + 1) > 0) {
                        continue outer;
                    }
                }
                for (String foundWord : foundWords) {
                    if (foundWord.equalsIgnoreCase(word)) {
                        continue outer;
                    }
                }
                foundWords.add(word);
            }
            if (!foundWords.isEmpty()) {
                StringBuilder builderFountWords = new StringBuilder();

                for (String word : foundWords) {
                    builderFountWords.append(word).append(" ");
                }
                System.out.print(builderFountWords.toString().trim());
            } else {
                System.out.print("NOT FOUND");
            }
        }
    }
}
