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
        // TODO реализация

            Scanner scanner = new Scanner(System.in);
            int N = Integer.parseInt(scanner.nextLine());
            int vowels = 0;
            int consonants = 0;
            int countWordsWithSameNumVowelsAndConsonants = 0;
            String[] InputArr = new String[N];
            for (int i = 0; i < N; i++) {
                InputArr[i] = String.valueOf(scanner.next());

                if (InputArr[i].matches("[a-zA-Z]+")) {

                    for (int j=0; j<InputArr[i].length(); j++) {
                       if ("AEIOUYaeiouy".indexOf(InputArr[i].charAt(j)) != -1) vowels++;
                        else consonants++;
                        }
                    if (vowels == consonants) countWordsWithSameNumVowelsAndConsonants++;
                    }
                }

        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }
}

