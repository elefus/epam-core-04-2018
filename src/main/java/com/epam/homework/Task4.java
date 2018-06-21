package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Set<String> wordsSet = new HashSet<>();
            int quantity = Integer.parseInt(reader.readLine());
            int countMin = 0;
            int count = 0;
            int number = 0;

            String[] words = reader.readLine().trim().split(" ");
            String[] letters;

            for (int i = 0; i < words.length; i++) {
                if (!words[i].isEmpty() && !words[i].equals(" ") && count < quantity){
                    letters = words[i].trim().split("");

                    for (String let : letters){
                        if(!(let.isEmpty() || let.equals(" ")))
                            wordsSet.add(let.trim());
                    }

                    if (wordsSet.size() < countMin || countMin == 0) {
                        countMin = wordsSet.size();
                        number = i;
                    }
                    wordsSet.clear();
                    count++;
                }
            }
            System.out.println(words[number]);
        }
    }
}
