package com.epam.homework;

import java.util.*;

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
        int minLen = Integer.MAX_VALUE;
        String targetWord = "NOT FOUND";

        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();

        List<String> A = Arrays.asList(in.nextLine().split("\\s+"));

        int i=0;
        for (String s : A) {
            if(i<num) words.add(s);
            i++;
        }

        for (String word : words) {
            boolean increase = true;
            if (word.length()>1) {
                for (int j = 0; j < word.length()-1; j++) {
                    if (!(word.charAt(j) < word.charAt(j + 1))){
                        increase = false;
                    }
                }
                if(increase){
                    targetWord = word;
                    break;
                }
            }
        }

        System.out.println(targetWord);
    }
}
