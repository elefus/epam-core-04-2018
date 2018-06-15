package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24class implements Task24 {

    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> sumPolynomials = new HashMap<>(first);
        for (Map.Entry<Integer, Integer> map : second.entrySet()) {
            if (!sumPolynomials.containsKey(map.getKey())) {
                sumPolynomials.put(map.getKey(), map.getValue());
            }

        }
        for (Map.Entry<Integer, Integer> map : sumPolynomials.entrySet()) {
            map.setValue(first.getOrDefault(map.getKey(), 0) + second.getOrDefault(map.getKey(), 0));
        }
        return sumPolynomials;
    }
}
