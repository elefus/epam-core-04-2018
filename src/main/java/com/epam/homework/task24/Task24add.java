package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24add implements Task24 {

    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>(first);
        second.forEach((key, value) -> {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        });
        return result;
    }
}

