package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
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
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        List<String> palindromes = new ArrayList<>();

        outer:
        for (int i = 0; i < quantity; i++) {
            String word = scanner.next();

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) < '0' || word.charAt(j) > '9'){
                    continue outer;
                }
            }
            for (int j = 0; j < word.length() / 2; j++) {
                if (word.charAt(j) != word.charAt(word.length() - j - 1)){
                    continue outer;
                }
            }
            if (!palindromes.contains(word)){
                palindromes.add(word);
            }
            if (palindromes.size() == 2){
                System.out.println(palindromes.get(1));
                return;
            }
        }
        if (palindromes.isEmpty()){
            System.out.println("NOT FOUND");
        } else {
            System.out.println(palindromes.get(0));
        }
    }
}
