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
        LinkedList<String> targetWords = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();

        List<String> A = Arrays.asList(in.nextLine().split("\\s+"));

        int i = 0;
        for (String s : A) {
            if (i < num) words.add(s);
            i++;
        }

        HashSet<String> existsWords = new HashSet<>();

        for (String word : words) {
            HashSet<Character> existsChars = new HashSet<>();
            boolean exit = false;
            String lowerCase = word.toLowerCase();
            for (char c : lowerCase.toCharArray()) {
                if (!(existsChars.contains(c))) {
                    existsChars.add(c);
                } else exit = true;
            }

            if (!exit && !existsWords.contains(word.toLowerCase())) {
                targetWords.add(word);
                existsWords.add(word.toLowerCase());
            }
        }

        if (targetWords.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(String.join(" ", targetWords));
        }
    }
}

