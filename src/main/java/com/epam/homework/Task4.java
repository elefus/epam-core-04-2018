package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

   private static int countNumDiffLetters (String word) {
        Set<Character> uniqueLettersInWord = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            uniqueLettersInWord.add(word.charAt(i));
        }

        return uniqueLettersInWord.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        in.nextLine();

        String wordWithMinimalNumDiffLetters = in.next();
        int minimalNumDiffLetters = countNumDiffLetters(wordWithMinimalNumDiffLetters);

        String tempWord;
        int numOfDiffLetters;

        for (int i = 1; i < N; i++) {
            tempWord = in.next();
            numOfDiffLetters = countNumDiffLetters(tempWord);

            if (numOfDiffLetters < minimalNumDiffLetters) {
                wordWithMinimalNumDiffLetters = tempWord;
                minimalNumDiffLetters = numOfDiffLetters;
            }
        }

        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
