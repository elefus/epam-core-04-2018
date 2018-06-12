package com.epam.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    /**
     * Ввести N строк с консоли.
     * Вывести те строки, длина которых меньше средней.
     * Под 'средней' подразумевается среднеарифметическая величина длины всех строк, округленная до целого в меньшую сторону.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество доступных для чтения строк
     * N строк
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена средняя длина (округленная до целого в меньшую сторону) и строки, удовлетворяющие условию.
     * Порядок появления строк в выходном потоке должен совпадать с порядком их появления во входном.
     * <p>
     * AVERAGE (средняя длина)
     * (длина строки): строка с длиной меньше средней
     * ...
     * (длина строки): строка с длиной меньше средней
     * <p>
     * ------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Послушайте!
     * Ведь, если звезды зажигают -
     * Значит - это кому-нибудь нужно?
     * Значит - кто-то хочет, чтобы они были?
     * Значит - кто-то называет эти плевочки жемчужиной?
     * <p>
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> allStrings = new ArrayList<>();
        int numOfStrings = scanner.nextInt();
        scanner.nextLine();
        long summaryLength = 0;

        for (int i = 0; i < numOfStrings; i++) {
            String currentString = scanner.nextLine();
            summaryLength += currentString.length();
            allStrings.add(currentString);
        }

        long averageLength = summaryLength / numOfStrings;

        System.out.println("AVERAGE (" + averageLength + ")");

        for (String current : allStrings) {
            if (current.length() < averageLength) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
    }
}
