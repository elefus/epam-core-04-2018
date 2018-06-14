package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Solution implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {

        Map<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            if (result.containsKey(entry.getKey())) {
                result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
