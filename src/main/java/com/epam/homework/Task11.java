package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task11 {

    /**
     * Ввести число с консоли.
     * С использованием рекурсии вычислить сумму цифр, из которых составлено указанное число.
     *
     * Формат входных данных:
     * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
     *
     * Формат выходных данных:
     * sum - сумма цифр, составляющих исходное число
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 25593
     *
     * Выходные данные:
     * 24
     *
     *
     * Входные данные:
     * -50
     *
     * Выходные данные:
     * 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String valueString = scanner.next();
        List<Integer> valueList = new ArrayList<>();

        if (valueString.charAt(0) == '-'){
            valueString = valueString.substring(1);
        }
        for (String value : valueString.split("")) {
            valueList.add(Integer.parseInt(value));
        }
        System.out.println(sum(valueList));
    }

    static int sum(List<Integer> valueList){
        if (valueList.size() > 1){
            valueList.set(0, valueList.get(0) + valueList.get(valueList.size() - 1));
            valueList.remove(valueList.size() - 1);
        }
        return valueList.size() == 1 ? valueList.get(0) : sum(valueList);
    }
}
