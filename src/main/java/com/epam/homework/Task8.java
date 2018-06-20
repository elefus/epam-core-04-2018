package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int GET_PALINDROME_INDEX = 2;

        int n = Integer.parseInt(reader.readLine());
        String[] inputWords = reader.readLine().split(" ");

        List<String> palindromes = Arrays.stream(inputWords)
                .limit(n)
                .filter(s -> s.matches("[0-9]+"))
                .filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
                .distinct()
                .limit(GET_PALINDROME_INDEX)
                .collect(Collectors.toList());

        if (!palindromes.isEmpty()) {
            System.out.println(palindromes.get(palindromes.size() - 1));
        } else {
            System.out.println("NOT FOUND");
        }
    }
}
