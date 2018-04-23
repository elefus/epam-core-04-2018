package com.epam.homework;

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
        Scanner scan = new Scanner(System.in);
        //int n = Integer.parseInt(scan.nextLine());
        int n = scan.nextInt(); scan.nextLine();
        String maxString = "";
        String minString = "";
        for (int i = 0; i < n; i++) {
            String cur = scan.nextLine();
            if(cur.length() >= maxString.length() || i==0){
                maxString = cur;
            }
            if(cur.length() <= minString.length() || i==0){
                minString = cur;
            }
        }
        System.out.println("MIN (" + minString.length() + "): " + minString);
        System.out.println("MAX (" + maxString.length() + "): " + maxString);
    }
}
