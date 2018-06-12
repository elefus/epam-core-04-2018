package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
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

        Scanner in = new Scanner(System.in);
        Integer numbOfWords = in.nextInt();

        List<String> inputWords= new ArrayList<>();

        for (int i = 0; i < numbOfWords; i++) {
            inputWords.add(in.next());
        }

        System.out.println(printWordWithStrictCodeOrder(inputWords));
    }

    private static String printWordWithStrictCodeOrder(List<String> words) {

        for (String currentWord : words) {
            if (currentWord.length() == 1) {
                continue;
            }

            for (int i = 0; i < currentWord.length() - 1; i++) {
                if (currentWord.charAt(i) >= currentWord.charAt(i + 1)) {
                    break;
                } else {
                    if (i == currentWord.length() - 2) {
                        return currentWord;
                    }
                }
            }
        }
        return "NOT FOUND";
    }
}
