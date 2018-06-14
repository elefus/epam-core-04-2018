package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Implementation implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> resultMap = new HashMap<>(first);
        second.forEach((key, value) -> {
            if (resultMap.containsKey(key)) {
                resultMap.put(key, resultMap.get(key) + value);
            } else {
                resultMap.put(key, value);
            }
        });
        return resultMap;
    }
}
