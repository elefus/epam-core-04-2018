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
        String answer = "NOT FOUND";
        Scanner scanner = new Scanner(System.in);
        int numOfWords = scanner.nextInt();
        scanner.nextLine();
        String[] wordsFromInput = scanner.nextLine().split(" ", numOfWords);

        for (String current : wordsFromInput) {
            boolean isWordWithCharsCodeInAscendingOrderFound = false;

            for (int i = 0; i < current.length() - 1; i++) {
                if (current.charAt(i) >= current.charAt(i + 1)) {
                        break;
                    } else {
                        if (current.length() == i + 2) {
                            isWordWithCharsCodeInAscendingOrderFound = true;
                        }
                    }
                }

            if (isWordWithCharsCodeInAscendingOrderFound) {
                answer = current;
                break;
            }
        }
        System.out.println(answer);
    }
}