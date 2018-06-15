package com.epam.homework;

import java.util.Scanner;

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
            int wordsCount = reader.nextInt();
            String result = "NOT FOUND";

            for (int i = 0, uniquePalindromesCount = 0; i < wordsCount; i++) {
                String nextWord = reader.next();

                if (isParsedToInteger(nextWord) && isPalindrome(nextWord) && !result.equals(nextWord)) {
                    result = nextWord;
                    if (++uniquePalindromesCount > 1) break;
                }
            }

            System.out.println(result);
        }
    }

    private static boolean isParsedToInteger(String str) {
        for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) return false;

        return true;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--)
            if (str.charAt(i) != str.charAt(j)) return false;

        return true;
    }
}
