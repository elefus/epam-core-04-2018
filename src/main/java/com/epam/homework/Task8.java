package com.epam.homework;

import java.util.LinkedList;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int numberWords = scanner.nextInt();
        LinkedList<String> uniquePalindrome = new LinkedList<>();

        while (numberWords-- > 0) {
            String currentValue = scanner.next();
            if (isNumber(currentValue) && isPalindrome(currentValue)) {
                if (uniquePalindrome.isEmpty()) {
                    uniquePalindrome.add(currentValue);
                } else if (!(uniquePalindrome.getLast().equals(currentValue)) && uniquePalindrome.size() < 2) {
                    uniquePalindrome.add(currentValue);
                }
            }
        }
        if (uniquePalindrome.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(uniquePalindrome.getLast());
        }
    }

    private static boolean isNumber(String value) {
        return value.matches("\\d+");
    }

    private static boolean isPalindrome(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt((value.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }
}
