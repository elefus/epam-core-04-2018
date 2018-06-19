package com.epam.homework.task24;

import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Осуществляет сложение двух многочленов.
 * Коэффициенты многочленов хранятся в объекте Map.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 * first Первый многочлен.
 * second Второй многочлен.
 * Многочлен, полученный в результате сложения.
 */

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> answer = new HashMap<>(first);

        for (Integer currentKey : second.keySet()) {
            if (answer.containsKey(currentKey)) {
                answer.put(currentKey, first.get(currentKey) + second.get(currentKey));
            } else {
                answer.put(currentKey, second.get(currentKey));
            }
        }
        return answer;
    }
}
