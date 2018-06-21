package com.epam.homework;

import java.util.Arrays;
import java.util.HashSet;
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
        Scanner sc = new Scanner(System.in);
        int numOfWords = sc.nextInt();
        sc.nextLine();
        StringBuilder answer = new StringBuilder("");
        String[] inputWords = new String[numOfWords];
        Set<Character> lettersFromCurrentWord = new HashSet<>();
        int counterOfWordsInAnswer = 0;

        for (int i = 0; i < numOfWords; i++) {
            inputWords[i] = sc.next().toLowerCase();
        }

        for (String current : inputWords) {

            for (int k = 0; k < current.length(); k++) {
                lettersFromCurrentWord.add(current.charAt(k));
            }
            if (lettersFromCurrentWord.size() == current.length()
                    && !answer.toString().matches("(.*)" + current + "(.*)")) {
                counterOfWordsInAnswer++;
                answer.append(current).append(" ");
            }
            lettersFromCurrentWord.clear();
        }
        if (counterOfWordsInAnswer == 0) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(answer.toString());
        }
    }
}