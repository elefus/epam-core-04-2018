package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] array = reader.readLine().trim().split(" ");

        int sum = 0;


        boolean found = true;
        for (int i = 0; i < count; i++){
            found = true;
            for (int j = 0; j < array[i].length()-1; j++) {
                if (array[i].charAt(j)>=array[i].charAt(j+1)){
                    found = false;
                }

            }
            if (array[i].length()==1){found = false;}
            if (found){System.out.println(array[i]);break;}

        }
        if (!found){System.out.println("NOT FOUND");}

    }
}
