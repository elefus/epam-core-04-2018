package com.epam.homework;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        String[] words = input.split(" ", count);
        Set<String> uniquePals = new LinkedHashSet<>();

        for (String word : words) {
            if (isNumber(word) && isPalindrome(word)) {
                uniquePals.add(word);
            }
        }

        String[] output = uniquePals.toArray(new String[0]);

        switch (output.length) {
            case 0:
                System.out.println("NOT FOUND");
                break;
            case 1:
                System.out.println(output[0]);
                break;
            default:
                System.out.println(output[1]);
                break;
        }
    }

    private static boolean isNumber(String str) {

        char[] charArr = str.toCharArray();
        for (char aCharArr : charArr) {
            if (!(Character.isDigit(aCharArr))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(String str) {

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String reverse = sb.toString();
        return (reverse.equals(str));
    }
}