package com.epam.homework;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            List<String> wordList = Arrays.asList(br.readLine().split("\\s")).subList(0, n);
            String fitWord = "NOT FOUND";
            label:
            for (String word : wordList) {
                char[] wordAsChars = word.toCharArray();
                if (wordAsChars.length > 1) {
                    for (int i = 0; i < wordAsChars.length - 1; i++) {
                        if (wordAsChars[i] >= wordAsChars[i + 1]) {
                            continue label;
                        }
                    }
                    fitWord = word;
                    break;
                }
            }
            bw.write(fitWord);
        }
    }
}
