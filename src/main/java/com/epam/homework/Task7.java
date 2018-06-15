package com.epam.homework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        Set<String> set = new LinkedHashSet<>();
        String result = "";

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            String lowerCaseString = str.toLowerCase();
            if (isDifferentChars(lowerCaseString) && !(set.contains(lowerCaseString))) {
                set.add(lowerCaseString);
                result = result + str + " " ;
            }
        }
        if (set.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(result.trim());
        }
    }

    public static boolean isDifferentChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i))) {
                return false;
            } else {
                set.add(word.charAt(i));
            }
        }
        return true;
    }
}

