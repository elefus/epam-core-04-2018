package com.epam.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным
     * числом гласных и согласных букв.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов
     * латинского алфавита и содержащих равное количество гласных и согласных букв.
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
        scanner.nextLine();

        String[] inputWords=new String[numOfWords];

        List<String> onlyEnglishWords = new ArrayList<>();

        for (int i = 0; i < numOfWords; i++) {
            inputWords[i] = scanner.next().toLowerCase();
        }


        getOnlyEnglishWordsWithEvenNumberOfLetters(inputWords, onlyEnglishWords);
        System.out.println(getNumberOfWordsWithEqualNumberOfConsonantsAndVowels(onlyEnglishWords));
    }

    private static int getNumberOfWordsWithEqualNumberOfConsonantsAndVowels(List<String> onlyEnglishWords) {
        int numberOfWordsWithEqualNumberOfConsonantsAndVowels = 0;

        for (String current : onlyEnglishWords) {
            int vowelsInCurrentWord = 0;

            for (int i = 0; i < current.length(); i++) {

                if (current.substring(i, i + 1).matches("[aeiouy]")) {
                    vowelsInCurrentWord++;
                }
            }

            if (vowelsInCurrentWord == current.length() / 2) {
                numberOfWordsWithEqualNumberOfConsonantsAndVowels++;
            }
        }
        return numberOfWordsWithEqualNumberOfConsonantsAndVowels;
    }

    private static void getOnlyEnglishWordsWithEvenNumberOfLetters(String[] wordsFromInput, List<String> onlyEnglishWords) {
        for (String current : wordsFromInput) {
            boolean hasEvenNumberOfLetters = current.length() % 2 == 0;

            if (hasEvenNumberOfLetters && current.matches("[a-z]+")) {
                onlyEnglishWords.add(current);
            }
        }
    }


}
