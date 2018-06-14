package com.epam.homework.task24;

import java.util.*;

public class Task24Impl implements Task24{

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
        Map<Integer, Integer> result = new HashMap<>(second);

        Set<Integer> setKeys = first.keySet();

        for (Integer key : setKeys) {
            if(second.containsKey(key)){
                result.put(key,first.get(key) + second.get(key));
            }
            else {
                result.put(key,first.get(key));
            }
        }
        return result;
    }
}
