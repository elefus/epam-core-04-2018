package com.epam.homework;

import java.util.*;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     * <p>
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> inWords = new ArrayList<>();
        int counter = Integer.valueOf(in.nextLine());
        for (int i = 0; i < counter; i++) {
            inWords.add(in.next().toLowerCase());
        }
        System.out.println(String.join(" ", wordsWithDifferentLetters(inWords)));
    }

    private static Set<String> wordsWithDifferentLetters(ArrayList<String> words) {
        Set<String> result = new LinkedHashSet<>();
        for (String wordCount : words) {
            int count = new HashSet<String>(Arrays.asList(wordCount.split(""))).size();
            if (count == wordCount.length()) {
                result.add(wordCount);
            }
        }
        if (result.isEmpty()) {
            result.add("NOT FOUND");
        }
        return result;
    }
}
