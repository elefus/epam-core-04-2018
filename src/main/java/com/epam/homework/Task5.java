package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int countWordsWithSameNumVowelsAndConsonants = 0;

        String[] inputWords = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            if (onlyLatinAlphabet(inputWords[i]) && (countVowels(inputWords[i]) == countConsonants(inputWords[i]))) {
                countWordsWithSameNumVowelsAndConsonants++;
            }
        }

        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }

    private static boolean onlyLatinAlphabet(String string) {
        return string.matches("[a-zA-Z]+");
    }

    private static int countVowels(String string) {
        final String vowels = "aeiouyAEIOUY";
        int countVowels = 0;
        for (int i = 0; i < string.length(); i++) {
            if (vowels.indexOf(string.charAt(i)) >= 0) {
                countVowels++;
            }
        }
        return countVowels;
    }

    private static int countConsonants(String string) {
        final String consonants = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        int countConsonants = 0;
        for (int i = 0; i < string.length(); i++) {
            if (consonants.indexOf(string.charAt(i)) >= 0) {
                countConsonants++;
            }
        }
        return countConsonants;
    }
}
