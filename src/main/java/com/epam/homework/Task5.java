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
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int countWordsWithSameNumVowelsAndConsonants = 0;
        int countVowel =0, countConsonant = 0;
        for (int i=0; i<n; i++) {
            String line = scanner.next();
            if (line.matches("[a-zA-Z]*")) {
                for (int j=0; j<line.length(); j++) {
                    if ("aeoiuAEOIU".indexOf(line.charAt(j)) != -1) countVowel++;
                    else countConsonant++;
                }
                if (countVowel == countConsonant) countWordsWithSameNumVowelsAndConsonants++;
            }
        }
       System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }
}
