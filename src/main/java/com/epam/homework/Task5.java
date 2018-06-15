package com.epam.homework;

import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int wordsCount = Integer.valueOf(reader.nextLine());
            int countWordsWithSameNumVowelsAndConsonants = 0;

            for (int i = 0; i < wordsCount; i++) {
                String nextWord = reader.next();

                if (isItConsistedOfLatinLetters(nextWord) &&
                        isItHasTheSameNumVowelsAndConsonants(nextWord)) {

                    countWordsWithSameNumVowelsAndConsonants++;
                }
            }

            System.out.println(countWordsWithSameNumVowelsAndConsonants);
        }
    }

    private static boolean isItConsistedOfLatinLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    private static boolean isItHasTheSameNumVowelsAndConsonants(String str) {
        int balance = 0;

        for (char letter: str.toCharArray()){
            if (isVowel(letter)) balance++;
            if (isConsonant(letter)) balance--;
        }

        return balance == 0;
    }

    private static boolean isVowel(char letter) {
        return "aeiouyAEIOUY".indexOf(letter) >= 0;
    }

    private static boolean isConsonant(char letter) {
        return "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ".indexOf(letter) >= 0;
    }
}
