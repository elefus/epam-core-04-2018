package com.epam.homework;

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
        // TODO реализация
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] InputArr = new String[N];
        int Summ = 0;

        for (int i = 0; i < N; i++) {
            InputArr[i] = String.valueOf(scanner.nextLine());
            Summ += InputArr[i].length();

        }
        int averageLength = Summ/N;

        System.out.println("AVERAGE (" + averageLength + ")");
        for(String current  : InputArr) {
        if (current.length()<averageLength) System.out.println("(" + current.length() + "): " + current);
        }
    }
}
