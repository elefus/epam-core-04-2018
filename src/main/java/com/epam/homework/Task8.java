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
        // TODO реализация

        try (Scanner scanner = new Scanner(System.in)) {
            int N = Integer.parseInt(scanner.nextLine());
            List<String> array = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String word = scanner.next();
                if (word.matches("[0-9]+")) {
                    StringBuilder sbuilder = new StringBuilder(word);
                    if (sbuilder.toString().equals(sbuilder.reverse().toString())) {
                        if (!array.contains(word))
                            array.add(word);
                    }
                }
            }
            ((ArrayList<String>) array).trimToSize();
            switch(array.size()) {
                case 1:
                    System.out.println(array.get(0));
                    break;
                case 0:
                    System.out.println("NOT FOUND");
                    break;
                default:
                    System.out.println(array.get(1));
                    break;

            }
        }

    }
}
