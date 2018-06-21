package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] array = reader.readLine().trim().split(" ");
        String minWord = "";
        int minLetters = 0;
        Map<Character, Integer> letters = new HashMap<Character, Integer>();

        for (int i = 0; i < count; i++){
            letters.clear();
            for (int j = 0; j < array[i].length(); j++){
                if (letters.containsKey(array[i].charAt(j))){
                    letters.put(array[i].charAt(j), letters.get(array[i].charAt(j)+1));
                }else{
                    letters.put(array[i].charAt(j), 1);
                }

            }

            if (letters.size()<minLetters || minLetters == 0){
                minLetters = letters.size();
                minWord = array[i];
            }

        }
        System.out.println(minWord);
    }
}

