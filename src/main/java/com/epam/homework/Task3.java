package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
5
Послушайте!
Ведь, если звезды зажигают -
Значит - это кому-нибудь нужно?
Значит - кто-то хочет, чтобы они были?
Значит - кто-то называет эти плевочки жемчужиной?
     *
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) {
        // TODO реализация
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            List<String> lines = new ArrayList<>();
            int lineNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < lineNum; i++) {
                lines.add(br.readLine());
            }
            int averageLength = (int) lines.stream().mapToInt(l -> l.length()).average().orElse(0);
            System.out.println("AVERAGE (" + averageLength + ")");
            lines.stream().filter(l -> l.length() < averageLength).forEach(current -> System.out.println("(" + current.length() + "): " + current));

        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
        // TODO System.out.println("AVERAGE (" + averageLength + ")");
        // TODO foreach($current : $result) {
        // TODO     System.out.println("(" + current.length() + "): " + current);
        // TODO }
    }
}
