package com.epam.homework;
import java.util.Scanner;
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordsAmount = Integer.parseInt(scanner.next());
        int count = Integer.MAX_VALUE;
        String wordWithMinimalNumDiffLetters = "";
        HashSet<Character> word;
        for (int i = 0; i < wordsAmount; i++) {
            String indispensableWord = scanner.next();
            word = new HashSet<>();
            for (int j = 0; j < indispensableWord.length(); j++) {
                word.add(indispensableWord.charAt(j));
            }
            if (word.size() < count) {
                count = word.size();
                wordWithMinimalNumDiffLetters = indispensableWord;
            }
        }
        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
