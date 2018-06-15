package com.epam.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String[] result = new String[Integer.parseInt(reader.readLine())];
            int count = 0;

            for (int i = 0; i < result.length; i++) {
                result[i] = reader.readLine();
                count += result[i].length();
            }

            int averageLength = count / result.length;

            System.out.println("AVERAGE (" + averageLength + ")");

            for(String current : result) {
                if(current.length() < averageLength)
            System.out.println("(" + current.length() + "): " + current);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
