package com.epam.homework;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     * <p>
     * Выходные данные:
     * 2
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int countWordsWithSameNumVowelsAndConsonants = 0;

        HashSet<Character> consonants = new HashSet<>();
        Collections.addAll(consonants, 'a', 'e', 'i', 'o', 'u', 'y');
        HashSet<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z');

        for (int i = 0; i < n; i++) {
            if (isWordsWithSameNumVowelsAndConsonants(scanner.next().toLowerCase(),consonants,vowels)) {
                countWordsWithSameNumVowelsAndConsonants++;
            }
        }
        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }

    static boolean isWordsWithSameNumVowelsAndConsonants(String word, HashSet consonants, HashSet vowels) {

        if (word.length() % 2 != 0)
            return false;

        int numberVowels = 0;
        int numberConsonants = 0;

        for (int i = 0; i < word.length(); i++) {
            if (consonants.contains(word.charAt(i))) {
                numberConsonants++;
            } else if (vowels.contains(word.charAt(i))) {
                numberVowels++;
            } else {
                return false;
            }
        }
        return (numberConsonants == numberVowels);
    }
}