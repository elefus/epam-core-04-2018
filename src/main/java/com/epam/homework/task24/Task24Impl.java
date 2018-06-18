package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    /**
     * Осуществляет сложение двух многочленов.
     * Коэффициенты многочленов хранятся в объекте Map.
     * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
     * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
     *
     * @param first  Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            result.putIfAbsent(entry.getKey(), 0);
            result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
        }

        return result;
    }
}
