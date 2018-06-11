package com.epam.homework;


import java.util.Scanner;
import java.io.IOException;
import java.util.HashSet;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>`
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        int counter = Integer.MAX_VALUE;
        String wordWithMinimalNumDiffLetters = "";
        HashSet<Character> characters;
        for (int i = 0; i < N; i++) {
            String string = scanner.next();
            characters = new HashSet<>();
            for (int j = 0; j < string.length(); j++) {
                characters.add(string.charAt(j));
            }
            if (characters.size() < counter) {
                counter = characters.size();
                wordWithMinimalNumDiffLetters = string;
            }
        }
        System.out.println(wordWithMinimalNumDiffLetters);
    }
}