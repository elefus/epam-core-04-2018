package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */

    static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    static final Set<Character> consonant = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'));

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int lineNum = Integer.parseInt(br.readLine());
            List<String> lines = Arrays.asList(br.readLine().toLowerCase().split(" ")).subList(0, lineNum);
           int result = (int)lines.stream().filter(l -> {
                List<Character> lineList = l.chars().mapToObj(e->(char)e)
                        .collect(Collectors.toList());
                return intersection(lineList);
            }).count();
            System.out.println(result);
        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }
    public static boolean intersection(List<Character> listChar) {
        int vowelCounter = 0;
        int consonantCounter = 0;
        for (Character x : listChar) {
            if (vowels.contains(x))
                vowelCounter++;
            else if (consonant.contains(x))
                consonantCounter++;
            else
                return false;
        }
        return vowelCounter == consonantCounter;
    }
}
