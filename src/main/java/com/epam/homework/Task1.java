package com.epam.homework;
import java.io.IOException;
import java.util.ArrayList;
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

        ArrayList<String> userLines = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in a text here.");

        while (true) {
            String curr = sc.nextLine();
            if (curr.equals("")) {
                break;
            }
            userLines.add(curr);
        }

        if ((userLines.size() < 1) || (userLines.size() > 99)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String shortest = userLines.get(0);
        String longest = userLines.get(0);

        for (int i = 0; i < userLines.size(); i++) {
            if (userLines.get(i).length() <= shortest.length()) {
                shortest = userLines.get(i);
            }

            if (userLines.get(i).length() >= longest.length()) {
                longest = userLines.get(i);
            }
        }

        System.out.println("\nMIN (" + shortest.length() + "): " + shortest);
        System.out.println("MAX (" + longest.length() + "): " + longest);

    }

}