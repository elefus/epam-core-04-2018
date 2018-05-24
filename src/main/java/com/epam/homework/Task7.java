package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
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

        Scanner scanner = new Scanner(System.in);
        int numOfWords = scanner.nextInt();
        boolean isFirstWord = true;
        for (int i = 0; i < numOfWords; i++) {
            String word = scanner.next();
            if (word.length() == numOfUniqueLetters(word)) {
                if (!isFirstWord) {
                    System.out.print(" ");
                }
                isFirstWord = false;
                System.out.print(word);
            }
        }
    }

    private static int numOfUniqueLetters(String word) {
        boolean onlyLatinAlphabet = word.matches("^[a-zA-Z0-9]+$");
        Set<Character> uniqueWords = new HashSet<>();

        if (!onlyLatinAlphabet) {
            return 0;
        }
        for (int i = 0; i < word.length(); i++) {
            uniqueWords.add(word.charAt(i));
        }
        return uniqueWords.size();
    }
}
