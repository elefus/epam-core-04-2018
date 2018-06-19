package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<String> wordList = new ArrayList<>(Arrays.asList(br.readLine().split("\\s")).subList(0, n));
            String result = "NOT FOUND";
            boolean isPalindromeFound = false;
            for (String word : wordList) {
                if (word.matches("[0-9]+")) {
                    if (word.equals(new StringBuilder(word).reverse().toString())) {
                        if (!word.equals(result)) {
                            if (isPalindromeFound) {
                                result = word;
                                break;
                            }
                        }
                        result = word;
                        isPalindromeFound = true;
                    }
                }
            }
            System.out.println(result);
        }
    }
}