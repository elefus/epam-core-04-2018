package com.epam.homework;

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
        int counter = Integer.parseInt(scanner.nextLine());
        int countWordsWithSameNumVowelsAndConsonants = 0;
        for (int i = 0; i < counter; i++) {
            String words = scanner.next();
            if (isLatin(words)) {
                if (Vowels(words) == Consonants(words)) {
                    countWordsWithSameNumVowelsAndConsonants++;
                }
            }
        }
        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }

    private static boolean isLatin(String str) {
        return str.matches("[a-zA-Z]+");
    }

    private static boolean isVowels(char ch) {
        return "aeiouyAEIOUY".indexOf(ch) >= 0;
    }

    private static boolean isConsonants(char ch) {
        return "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ".indexOf(ch) >= 0;
    }

    private static int Vowels(String str) {
        int numberofvowels = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowels(str.charAt(i))) {
                numberofvowels++;
            }
        }
        return numberofvowels;
    }

    private static int Consonants(String str) {
        int numberofconsonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isConsonants(str.charAt(i))) {
                numberofconsonants++;
            }
        }
        return numberofconsonants;
    }
}