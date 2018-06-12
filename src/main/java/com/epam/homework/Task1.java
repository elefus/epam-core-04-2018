package com.epam.homework;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer N = in.nextInt();
        in.nextLine();

        Integer minLength = Integer.MAX_VALUE;
        Integer maxLength  = Integer.MIN_VALUE;
        String minString = "";
        String maxString = "";

        for (int i = 0; i < N; i++) {
            String inputString = in.nextLine();
            if(inputString.length() <= minLength){
                minLength  = inputString.length();
                minString = inputString;
            }
            if(inputString.length() >= maxLength) {
                maxLength = inputString.length();
                maxString = inputString;
            }
        }

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }
}
