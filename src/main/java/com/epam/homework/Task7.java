package com.epam.homework;

import java.util.*;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     *
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        String[] words = input.split(" ", count);
        Set<String> uniqueWords = new LinkedHashSet<>();

        for (String word : words) {
            if (areCharsUnique(word)) {
                uniqueWords.add(word);
            }
        }

        String[] output = uniqueWords.toArray(new String[0]);

        if (output.length == 0) {
            System.out.println("NOT FOUND");
        } else
            for (String i : output) {
            System.out.print((i + " "));
        }
    }

    private static boolean areCharsUnique (String str) {

        Set<Character> uniqueChars = new HashSet<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            boolean add = uniqueChars.add(str.charAt(i));
            if (!add) {
                return false;
            }
        }
        return true;
    }
}
