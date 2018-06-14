package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        String wordWithMinimalNumDiffLetters = "";
        int minSize = Integer.MAX_VALUE;
        HashSet <Character> count = new HashSet<>();
        for (int i=0; i<n; i++) {
            String line = scanner.next();
                for (int j = 0; j < line.length(); j++) {
                    count.add(line.charAt(j));
                }
                if (count.size() < minSize) {
                    minSize = count.size();
                    wordWithMinimalNumDiffLetters = line;
                }
                count.clear();
            }
        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
