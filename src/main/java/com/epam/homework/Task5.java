package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] array = reader.readLine().trim().split(" ");

        int sum = 0;
        int lowercase;
        int uppercase;

        for (int i = 0; i < count; i++){

            if ( array[i].matches( "^[a-zA-Z]+$" ) && (array[i].length() % 2 == 0) ) {
                lowercase=0;
                uppercase=0;
                for (int j = 0; j < array[i].length(); j++){
                    if (Character.toString(array[i].charAt(j)).matches("(?i:[aeiouy]).*")){
                        lowercase++;
                    }else{
                        uppercase++;
                    }
                }
                if (lowercase == uppercase) {
                    sum++;
                }
            }

        }
        System.out.println(sum);
    }
}
