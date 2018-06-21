package com.epam.homework;

import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Scanner in = new Scanner(System.in);
        Integer numbsOfWords = in.nextInt();
        in.nextLine();

        String[] words = new String[numbsOfWords];

        for (int i = 0; i < numbsOfWords; i++) {
            words[i] = in.next();
        }


        System.out.println(getCountWordsWithSameNumVowelsAndConsonants(words));
    }

    private static Integer getCountWordsWithSameNumVowelsAndConsonants(String[] words) {

        Integer countWordsWithSameNumVowelsAndConsonants = 0;
        nextWord:
        for (String currentWord : words) {
            Integer countVowel = 0;
            Integer countConsonant = 0;

            for (int i = 0; i < currentWord.length(); i++) {
                if (!isLatin(currentWord.charAt(i))) {
                    continue nextWord;
                } else {
                    if (isVowel(currentWord.charAt(i))){
                        countVowel++;
                    } else {
                        countConsonant++;
                    }
                }
            }
            
            if (countConsonant.equals(countVowel))
                countWordsWithSameNumVowelsAndConsonants++;
        }
        return countWordsWithSameNumVowelsAndConsonants;
    }

    private static boolean isLatin(char letter) {
        return (letter >= 'A' && letter <= 'Z') || ((letter >= 'a' && letter <= 'z'));
    }
    private final static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'));

    private static boolean isVowel(char letter){
        return  vowels.contains(letter);
    }
}