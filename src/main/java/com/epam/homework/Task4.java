package com.epam.homework;

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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];
        for (int i = 0; i < N; i++) {
            InputArr[i] = String.valueOf(scanner.next());
        }

        int uniqueChars = 0;
        int mincount = countUniqueCharacters(InputArr[0]);
        String wordWithMinimalNumDiffLetters = InputArr[0];


       for (int i = 0; i < InputArr.length; i++) {
            if(countUniqueCharacters(InputArr[i])< mincount) {
                wordWithMinimalNumDiffLetters = InputArr[i];
                mincount = countUniqueCharacters(InputArr[i]);
            }
        }
        System.out.println(wordWithMinimalNumDiffLetters);
        System.out.println(mincount);
    }
    public static int countUniqueCharacters(String s) {
        char characters[] = s.toCharArray();
        int countOfUniqueChars = s.length();
        for (int i = 0; i < characters.length; i++) {
            if (i != s.indexOf(characters[i])) {
                countOfUniqueChars--;
            }
        }
        return countOfUniqueChars;
    }
}
