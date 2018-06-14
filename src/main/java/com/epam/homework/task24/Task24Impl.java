package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> sumPolynomials = new HashMap<>(first);

        for (Integer curKey : second.keySet()) {
            if (first.containsKey(curKey)) {
                sumPolynomials.put(curKey, first.get(curKey) + second.get(curKey));
            } else {
                sumPolynomials.put(curKey, second.get(curKey));
            }
        }
        return sumPolynomials;

    }
}
