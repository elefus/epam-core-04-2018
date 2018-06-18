package com.epam.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            int countVowels = 0;
            int countConsonants = 0;
            int countWordsWithSameNumVowelsAndConsonants = 0;

            for (int i = 0; i < number; i++) {
                String word = scanner.next();

                if(word.matches("(?i:[a-z])+")){

                    for (int j = 0; j < word.length(); j++) {
                        if (word.substring(j, j+1).matches("(?i:[eyuioa])+"))
                            countVowels++;
                        else countConsonants++;
                    }
                    if (countVowels == countConsonants)
                        countWordsWithSameNumVowelsAndConsonants++;

                    countVowels = 0;
                    countConsonants = 0;
                }
            }
            System.out.println(countWordsWithSameNumVowelsAndConsonants);
        }
    }
}
