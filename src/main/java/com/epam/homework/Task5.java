package com.epam.homework;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     * <p>
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) throws IOException {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'));
        Set<Character> consonants = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z', 'B', 'C', 'D', 'F', 'G', 'H', 'J',
                'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'));

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<String> wordList = Arrays.asList(br.readLine().split("\\s")).subList(0, n);
            int result = 0;

            label1: for (String word : wordList) {
                int vowConsBalance = 0;
                for(Character letter : word.toCharArray()){
                    if(consonants.contains(letter)){
                        vowConsBalance++;
                    }else if (vowels.contains(letter)){
                        vowConsBalance--;
                    }else{
                        continue label1;
                    }
                }
                if(vowConsBalance == 0){result++;}
            }
            System.out.println(result);
        }
    }
}
