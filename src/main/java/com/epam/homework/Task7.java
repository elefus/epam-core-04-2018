package com.epam.homework;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];
        boolean found = false;
        int uniqueChars = 0;

        for (int i = 0; i < N; i++) {
            InputArr[i] = String.valueOf(scanner.next());
        }
        Set<String> set = new LinkedHashSet<>();


        for (int i = 0; i < InputArr.length; i++) {
            if(wordIsUnique(InputArr[i].toLowerCase())) {
            set.add(InputArr[i]);
            found = true;
            }
        }
        if (!found) {
            System.out.println("NOT FOUND");
        }
        else {
            for (String word : set) {
                System.out.print(word + " ");
            }
        }
    }
    private static boolean wordIsUnique(String s) {
        char characters[] = s.toCharArray();
        int countOfUniqueChars = s.length();
        for (int i = 0; i < characters.length; i++) {
            if (i != s.indexOf(characters[i])) {
                countOfUniqueChars--;
            }
        }
        return (countOfUniqueChars == s.length());
    }
}
