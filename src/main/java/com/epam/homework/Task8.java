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

    public static boolean isNumber(String input) {
        for (int i = 0; i< input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String numberAsString) {
        int numberAsStringLastIndex = numberAsString.length() - 1;

        for (int i = 0; i < numberAsStringLastIndex / 2; i++) {
            if (numberAsString.charAt(i) != numberAsString.charAt(numberAsStringLastIndex - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();

        String userInput;
        String result = "NOT FOUND";
        int numPalindromesFound = 0;

        for (int i = 0; i < N; i++) {
            userInput = in.next();

            if ((isNumber(userInput)) && (isPalindrome(userInput))) {
                result = userInput;
                numPalindromesFound++;
            }

            if (numPalindromesFound > 1) {
                break;
            }
        }

        System.out.println(result);
    }
}
