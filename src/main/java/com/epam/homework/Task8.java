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

        LinkedHashSet<String> palindromes = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        int numOfWords = scanner.nextInt();

        for (int i = 0; i < numOfWords; i++) {
            String currentWord = scanner.next();
            if (currentWord.matches("[0-9]+")) {

                if (isPalindrome(currentWord)) {
                    palindromes.add(currentWord);
                }
            }
        }
        if (palindromes.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            int counterOfSecond = 0;
            Iterator<String> iterator = palindromes.iterator();
            while (iterator.hasNext()) {
                if(palindromes.size() == 1){
                    System.out.println(iterator.next());
                    return;
                }
                if(counterOfSecond == 1){
                    System.out.println(iterator.next());
                    return;
                }
                counterOfSecond++;
                iterator.next();
            }
        }
    }

    private static boolean isPalindrome(String string) {
        if (string.length() == 1) {
            return true;
        } else {
            for (int i = 0; i < string.length() / 2; i++) {
                if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
