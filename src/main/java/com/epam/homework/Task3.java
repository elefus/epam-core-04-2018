package com.epam.homework;

import java.io.*;

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
     5
     Послушайте!
     Ведь, если звезды зажигают -
     Значит - это кому-нибудь нужно?
     Значит - кто-то хочет, чтобы они были?
     Значит - кто-то называет эти плевочки жемчужиной?
     * <p>
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
                sum += arr[i].length();
            }
            int averageLen = sum / n;
            bw.write("AVERAGE (" + averageLen + ")" + System.lineSeparator());
            for (String cur : arr) {
                if(cur.length()<averageLen){
                    bw.write("(" + cur.length() + "): " + cur + System.lineSeparator());
                }
            }
        }
    }
}
