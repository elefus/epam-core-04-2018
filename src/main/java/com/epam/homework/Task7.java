package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     *
     * Выходные данные:
     * The is a
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] array = reader.readLine().trim().split(" ");

        int sum = 0;
        Set<Character> letters = new HashSet<Character>();
        Set<String> words = new HashSet<String>();


        boolean found = true;
        for (int i = 0; i < count; i++){
            found = true;
            letters.clear();
            String currient = array[i].toLowerCase();
            for (int j = 0; j < array[i].length()-1; j++) {
                if (letters.contains(currient.charAt(j))){found = false;}
                else{
                    letters.add(currient.charAt(j));
                }
            }

            if (array[i].length()==1){found = false;}
            if (found){
                if (!words.contains(currient)){
                    words.add(currient);
                }
            }

        }
        if (!words.isEmpty()){
            System.out.println(String.join(" ", words));
        }
        else{
            System.out.println("NOT FOUND");
        }

    }
}
