package com.epam.homework;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            List<String> wordList = Arrays.asList(br.readLine().split("\\s")).subList(0,n);
            String fitWord = "";
            int minNumberOfUniqueChars = Integer.MAX_VALUE;
            for (String word : wordList) {
                HashSet<Character> uniqueChars = new HashSet<>();
                for(Character curChar : word.toCharArray()){
                    uniqueChars.add(curChar);
                }
                if(uniqueChars.size() < minNumberOfUniqueChars){
                    minNumberOfUniqueChars = uniqueChars.size();
                    fitWord = word;
                }
            }
            bw.write(fitWord);
        }
    }
}
