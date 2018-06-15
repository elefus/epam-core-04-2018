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

        int countWordsWithSameNumVowelsAndConsonants = 0;

        try (Scanner in = new Scanner(System.in)) {

            int wordsCount = Integer.valueOf(in.nextLine());

            nextWord:
            for (int i = 0; i < wordsCount; i++) {

                String word = in.next().toLowerCase();

                int countVowels = 0;
                int countConsonants = 0;

                for (char ch : word.toCharArray()) {

                    if (ch < 'a' || ch > 'z') continue nextWord;

                    switch (ch) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                        case 'y':
                            countVowels++;
                            break;
                        default:
                            countConsonants++;
                    }
                }

                if (countVowels == countConsonants) {
                    countWordsWithSameNumVowelsAndConsonants++;
                }
            }
        }

        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }
}
