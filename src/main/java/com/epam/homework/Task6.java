package com.epam.homework;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     * <p>
     * Выходные данные:
     * by
     * <p>
     * ===================================================================================================
     * <p>
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     * <p>
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfWords = scanner.nextInt();

        for (int i = 0; i < numOfWords; i++) {
            String word = scanner.next();
            if (isNextLetterCodeGreater(word, 0)) {
                System.out.println(word);
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    private static boolean isNextLetterCodeGreater(String word, int i) {
        if (word.length() == 1) {
            return false;
        }
        if ((int) word.charAt(i) >= (int) word.charAt(i + 1)) {
            return false;
        }
        if ((word.length() - 2) == i) {
            return true;
        }
        return isNextLetterCodeGreater(word, ++i);
    }
}
