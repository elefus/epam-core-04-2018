package com.epam.homework;

import java.util.*;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countsOfWord = in.nextInt();

        List<String> inputWords = new ArrayList<>();
        for (int i = 0; i < countsOfWord; i++) {
            inputWords.add(in.next());
        }

        System.out.println(getTheSecondPalindromeOfNumber(inputWords, 2));
    }

    private static String getTheSecondPalindromeOfNumber(List<String> words, int wordOrder) {
        List<String> palindromeNumbers = new ArrayList<>();

        for (String currentWord : words) {
            StringBuilder reverseWord = new StringBuilder(currentWord).reverse();

            if (isNumber(currentWord) && currentWord.equals(reverseWord.toString())) {
                palindromeNumbers.add(currentWord);
            }

            if (palindromeNumbers.size() == wordOrder) {
                return palindromeNumbers.get(wordOrder - 1);
            }
        }

        if (palindromeNumbers.isEmpty()) {
            return "NOT FOUND";
        } else {
            return palindromeNumbers.get(0);
        }
    }

    private final static Set<Character> numbers = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

    private static boolean isNumber(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (!numbers.contains(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
