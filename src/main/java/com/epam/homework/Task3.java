package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    /**
     * Ввести N строк с консоли.
     * Вывести те строки, длина которых меньше средней.
     * Под 'средней' подразумевается среднеарифметическая величина длины всех строк, округленная до целого в меньшую сторону.
     *
     * Формат входных данных:
     * N (целое число) - количество доступных для чтения строк
     * N строк
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена средняя длина (округленная до целого в меньшую сторону) и строки, удовлетворяющие условию.
     * Порядок появления строк в выходном потоке должен совпадать с порядком их появления во входном.
     *
     * AVERAGE (средняя длина)
     * (длина строки): строка с длиной меньше средней
     * ...
     * (длина строки): строка с длиной меньше средней
     *
     * ------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Послушайте!
     * Ведь, если звезды зажигают -
     * Значит - это кому-нибудь нужно?
     * Значит - кто-то хочет, чтобы они были?
     * Значит - кто-то называет эти плевочки жемчужиной?
     *
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) {
        String[] lines;

        try (Scanner sc = new Scanner(System.in)){
            int count = Integer.valueOf(sc.nextLine());
            lines = new String[count];

            for (int i = 0; i < count; i++) {
                lines[i] = sc.nextLine();
            }
        }

        int averageLength = (int) Arrays.stream(lines).mapToInt(String::length).average().orElse(0);
        lines = Arrays.stream(lines).filter((line) -> line.length() < averageLength).toArray(String[]::new);

        System.out.println("AVERAGE (" + averageLength + ")");
        for (String line : lines) {
            System.out.println("(" + line.length() + "): " + line);
        }
    }
}
