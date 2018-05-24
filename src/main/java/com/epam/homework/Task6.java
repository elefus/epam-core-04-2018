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
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        String[] word = new String[n];
        boolean test = false;
        int count;
        for (int i = 0; i < n; i++) {
            word[i] = scanner.next();
            count = 0;
            if (word[i].length()>1) {
                for (int j = 0; j < word[i].length() - 1; j++) {
                    if (word[i].charAt(j) >= word[i].charAt(j + 1)) break;
                    else {
                        count++;
                        if (count == word[i].length() - 1)  {
                            System.out.println(word[i]);
                            test = true;
                        }
                    }
                }
            }
            if (test) break;
        }
        if (!test) System.out.println("NOT FOUND");
    }
}
