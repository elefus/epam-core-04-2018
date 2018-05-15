package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class Task8 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int amountOfWords = Integer.parseInt(scanner.nextLine());
            List<String> array = new ArrayList<>();
            for (int i = 0; i < amountOfWords; i++) {
                String word = scanner.next();
                StringBuilder builder = new StringBuilder(word);
                if (builder.toString().equals(builder.reverse().toString())) {
                    array.add(word);
                }
            }
            ((ArrayList<String>) array).trimToSize();
            if (array.size() == 1) {
                System.out.println(array.get(0));
            } else if (array.isEmpty()) {
                System.out.println("NOT FOUND");
            } else {
                System.out.println(array.get(1));
            }
        }
    }
}