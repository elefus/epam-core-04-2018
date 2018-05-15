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

        int words = Integer.parseInt(scanner.nextLine());
        boolean t = false;

        next:  for (int i = 0; i < words; i++) {
            String word = scanner.next().toLowerCase();
            if (word.length() == 1) continue next;

            else {
                int counter = 0;
                for (int y = 0; y < word.length()-1; y++) {
                    if (word.charAt(y) >= word.charAt(y+1)) {
                        continue next;
                    }
                    else {
                        counter++;
                    }
                }
                if (word.length()-1 == counter) {
                    System.out.println(word);
                    t = true;
                    break;
                }
            }
        }
        if (!t) {
            System.out.println("NOT FOUND");
        }
    }
}