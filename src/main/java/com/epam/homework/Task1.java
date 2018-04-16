package com.epam.homework;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import static java.lang.Integer.parseInt;


public class Task1 {

    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     *
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     *
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     *
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */
    public static void main(String[] args)throws Exception {

        int minLength = 0;
        int maxLength = 0;
        String minString = null;
        String maxString = null;
        int num = parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        while(num < 0 || num > 100){
            System.out.println("Введите, пожалуйста целое число от 0 до 100");
            num = parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        }

        for (int i = 0; i < num; i++) {
            String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if(minLength == 0 || minLength >= s.length()){
                minLength = s.length();
                minString = s;
            }

            if(maxLength <= s.length()){
                maxLength = s.length();
                maxString = s;
            }
        }

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }
}
