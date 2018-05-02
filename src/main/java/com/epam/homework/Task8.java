package com.epam.homework;

import java.io.IOException;
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
        int wordsCount = Integer.parseInt(scanner.next());
        int currentCount = 0;
        String isPolindrom = "";
        int countPolindrom = 0;
        while (currentCount < wordsCount) {
            String nextWord = scanner.next();
            if (nextWord.matches("[0-9]+") && isNuberPolindrom(nextWord) && !isPolindrom.equals(nextWord)) {
                isPolindrom = nextWord;
                countPolindrom++;
            }
            if (countPolindrom == 2) break;
            currentCount++;
        }
        if (countPolindrom == 0) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(isPolindrom);
        }
    }

    private static boolean isNuberPolindrom(String number) {
        boolean isNumberPolindromOrNot = true;
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt((number.length() - i) - 1)) {
                isNumberPolindromOrNot = false;
                break;
            }
        }
        return isNumberPolindromOrNot;
    }
}
