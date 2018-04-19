package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine().trim();
        String wordWithMinimalNumDiffLetters = line;
        int minSize = line.length();
        String[] array = line.split("\\s");
        HashSet <Character> count = new HashSet<>();
        for (String anArray : array) {
            for (int j = 0; j < anArray.length(); j++) {
                count.add(anArray.charAt(j));
            }
            if (count.size() < minSize) {
                minSize = count.size();
                wordWithMinimalNumDiffLetters = anArray;
            }
            count.clear();
        }
        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
