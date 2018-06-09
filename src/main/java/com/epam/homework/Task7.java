package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int lineNum = Integer.parseInt(br.readLine());
            List<String> words = Arrays.asList(br.readLine().split(" ", lineNum));
            words = words.stream()
                    .filter(w -> {
                        int[] chars = w.toLowerCase().chars().distinct().toArray();
                        if (chars.length != w.length())
                            return false;
                        if (!w.matches("\\w+"))
                            return false;
                        return true;
                    }).collect(Collectors.toList());
            if (!words.isEmpty()) {
                Set<String> wordsSet = new HashSet<>();
                List<String> result = new ArrayList<>();
                for (String word : words) {
                    String wordLowerCase = word.toLowerCase();
                    if (!wordsSet.contains(wordLowerCase)) {
                        wordsSet.add(wordLowerCase);
                        result.add(word);
                    }
                }
                System.out.println(result.stream().collect(Collectors.joining(" ")));
            } else
                System.out.println("NOT FOUND");

        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }
}
