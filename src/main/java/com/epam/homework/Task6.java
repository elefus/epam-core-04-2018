package com.epam.homework;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     *
     * Выходные данные:
     * by
     *
     * ===================================================================================================
     *
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     *
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int wordsCount = Integer.valueOf(reader.nextLine());

            for (int i = 0; i < wordsCount; i++) {
                String nextWord = reader.next();

                if (nextWord.length() > 1 && isConsistedOfCharactersArrangedInAscendingOrder(nextWord)) {
                    System.out.println(nextWord);
                    return;
                }
            }

            System.out.println("NOT FOUND");
        }
    }

    private static boolean isConsistedOfCharactersArrangedInAscendingOrder(String word) {
        for (int i = 0, j = 1; j < word.length(); i++, j++)
            if (word.charAt(i) >= word.charAt(j)) return false;

        return true;
    }
}
