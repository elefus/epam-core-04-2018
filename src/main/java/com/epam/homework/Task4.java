package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

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

        try (Scanner in = new Scanner(System.in)) {

            int count = Integer.valueOf(in.nextLine());
            String[] words = new String[count];

            for (int i = 0; i < count; i++) {
                words[i] = in.next();
            }

            String wordWithMinUniqueLettersCount = words[0];

            for (String word : words) {
                if (getUniqueLettersCount(word) < getUniqueLettersCount(wordWithMinUniqueLettersCount)) {
                    wordWithMinUniqueLettersCount = word;
                }
            }

            System.out.println(wordWithMinUniqueLettersCount);
        }
    }

    /**
     * Gets count of unique letters in the word
     */
    private static int getUniqueLettersCount(String word) {

        char[] letters = word.toCharArray();

        HashSet<Character> uniqueLetters = new HashSet<>();
        for (char letter : letters) {
            uniqueLetters.add(letter);
        }

        return uniqueLetters.size();
    }
}
