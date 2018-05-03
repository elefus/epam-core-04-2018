package com.epam.homework;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
     * <p>
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();
        int currentIndex = 0;
        int minWordIndex = 0;
        String[] wordsFromInput = new String[numberOfWords];

        inputToArrayOfStrings(scanner, numberOfWords, wordsFromInput);

        Set<Character> charsFromWordWithMinNumOfDiffLetters = new HashSet<>();
        Set<Character> currentWord = new HashSet<>();


        for (Character currentChar : wordsFromInput[0].toCharArray()) {
            charsFromWordWithMinNumOfDiffLetters.add(currentChar);
        }

        for (String currentString : wordsFromInput) {
            currentWord.clear();
            for (Character currentChar : currentString.toCharArray()) {
                currentWord.add(currentChar);
            }
            currentIndex++;
            if (currentWord.size() < charsFromWordWithMinNumOfDiffLetters.size()) {
                minWordIndex = currentIndex - 1;
                charsFromWordWithMinNumOfDiffLetters.clear();
                charsFromWordWithMinNumOfDiffLetters.addAll(currentWord);
            }
        }

        System.out.println("answer is " + wordsFromInput[minWordIndex]);
    }

    private static void inputToArrayOfStrings(Scanner scanner, int numberOfWords, String[] wordsFromInput) {
        for (int i = 0; i < numberOfWords; i++) {
            wordsFromInput[i] = scanner.next();
            System.out.println(wordsFromInput[i]);
        }
    }
}
//Cake isa a1 lie a2 lie