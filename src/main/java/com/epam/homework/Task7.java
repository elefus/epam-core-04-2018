package com.epam.homework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import static java.lang.String.join;

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
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        HashSet<String> resultLowerCase = new LinkedHashSet<>();
        HashSet<String> result = new LinkedHashSet<>();
        String output = "";
        for (int i = 0; i < n; i++) {
            String lineStart = scanner.next();
            String line = lineStart.toLowerCase();
            int count = 0;
            if (lineStart.matches("[a-zA-Z]+")) {
                for (int j=0; j<line.length(); j++) {
                    if (line.indexOf(line.charAt(j)) == line.lastIndexOf(line.charAt(j))) count++;
                    else break;
                }
            }
            if (count == line.length()) resultLowerCase.add(line);
            if (resultLowerCase.size()>result.size()) result.add(lineStart);
        }
        if (result.isEmpty()) System.out.println("NOT FOUND");
        else {
            for (String anResult : result) {
                output = join(" ", output, anResult);
            }
        }
        System.out.println(output.trim());
    }
}
