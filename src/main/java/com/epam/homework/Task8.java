package com.epam.homework;

import java.util.*;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     *
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            String result = palindromeSearch(reader);
            if (result.isEmpty())
                System.out.println("NOT FOUND");
            else
                System.out.println(result);
        }
    }

    private static String palindromeSearch(Scanner reader) {
        int wordsNum = Integer.valueOf(reader.nextLine());
        List<String> words = Arrays.asList(reader.nextLine().split(" ", wordsNum));
        String resultCandidate = "";
        for (String word: words) {
            if (isPalindromeNumber(word)){
                if (resultCandidate.isEmpty() || resultCandidate.equals(word)) {
                    resultCandidate = word;
                    continue;
                }
                return word;
            }
        }
        return resultCandidate;
    }

    private static boolean isPalindromeNumber(String word) {
        if (word.length() == 1 && isDigit(word.charAt(0)))
            return true;

        for (int i = 0; i <= word.length() / 2; i++) {
            char currentChar = word.charAt(i);
            if (isDigit(currentChar)) {
                char mirrorChar = word.charAt(word.length() - i - 1);
                if (currentChar == mirrorChar)
                    continue;
            }
            return false;
        }

        return true;
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

}
