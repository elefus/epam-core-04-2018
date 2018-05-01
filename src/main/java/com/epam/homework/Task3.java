package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
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
        List<String> stringList = new ArrayList<>();
        int amountOfStrings = scanner.nextInt();
        int avgLength;
        scanner.nextLine();

        for (int i = 0; i < amountOfStrings; i++) {
            String temp = scanner.nextLine();
            stringList.add(temp);
        }

        avgLength = getAvgLength(amountOfStrings, stringList);

        stringsSmallerThanAverage(stringList, avgLength);
    }

    private static void stringsSmallerThanAverage(List<String> stringList, int avgLength) {
        System.out.println("AVERAGE (" + avgLength + ")");
        for (String current : stringList) {

            if (current.length() < avgLength) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
    }

    private static int getAvgLength(int amountOfStrings, List<String> stringList) {
        int sumOfLengths = 0;
        for (String current : stringList) {
            sumOfLengths += current.length();
        }
        System.out.println(sumOfLengths + " sum and avg ");
        return sumOfLengths / amountOfStrings;
    }
}
