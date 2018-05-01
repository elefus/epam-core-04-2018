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
        int numOfWords = scanner.nextInt();

        int countWordsWithSameNumVowelsAndConsonants = 0;

        for (int i = 0; i < numOfWords; i++) {
            String word = scanner.next();
            int numOfVowels = 0;
            int numOfConsonants = 0;
            if (word.matches("(?i:[a-z])+")) {

                for (int j = 0; j < word.length(); j++) {
                    if (word.substring(j, j + 1).matches("(?i:[eyuioa])+")) {
                        numOfVowels++;
                    } else {
                        numOfConsonants++;
                    }
                }
                if (numOfVowels == numOfConsonants) {
                    countWordsWithSameNumVowelsAndConsonants++;
                }
            }
        }
        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }
}

