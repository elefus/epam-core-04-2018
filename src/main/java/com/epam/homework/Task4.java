package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numbsOfWords = in.nextInt();
        in.nextLine();

        String[] words = new String[numbsOfWords];

        for (int i = 0; i < words.length; i++) {
            words[i] = in.next();
        }

       System.out.println(getWordWithMinUniqueLetters(words));
    }

    private static String getWordWithMinUniqueLetters(String[] wordsArr) {

        String wordWithMinimalNumDiffLetters = wordsArr[0];
        Integer countMinUniqueChar = Integer.MAX_VALUE;
        for (String currentWord : wordsArr) {

            Set<Character> uniqueChar = new HashSet<>();

            for (int j = 0; j < currentWord.length(); j++) {
                uniqueChar.add(currentWord.charAt(j));
            }

            if (countMinUniqueChar > uniqueChar.size()) {
                countMinUniqueChar = uniqueChar.size();
                wordWithMinimalNumDiffLetters = currentWord;
            }
        }
        return wordWithMinimalNumDiffLetters;
    }

}

