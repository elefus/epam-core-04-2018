package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputWords = reader.readLine().split(" ");

        Set<String> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            final String current = inputWords[i];
            if (isFromDiffLetters(current) && result.stream().noneMatch(string -> string.equalsIgnoreCase(current))) {
                result.add(inputWords[i]);
            }
        }

        if (!result.isEmpty()) {
            System.out.println(String.join(" ", result));
        } else {
            System.out.println("NOT FOUND");
        }
    }

    private static boolean isFromDiffLetters(String string) {
        Set<String> diffLetters = new HashSet<>(Arrays.asList(string.split("")));
        return diffLetters.size() == string.length();
    }
}
