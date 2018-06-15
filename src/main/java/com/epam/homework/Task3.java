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
        int size = Integer.parseInt(scanner.nextLine());
        int averageLength = 0;
        ArrayList<String> arrayList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            arrayList.add(scanner.nextLine());
            averageLength += arrayList.get(i).length();
        }

        averageLength = size != 0 ? averageLength / size : 0;

        System.out.println("AVERAGE (" + averageLength + ")");
        for (String current : arrayList) {
            if (current.length() < averageLength) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
    }
}
