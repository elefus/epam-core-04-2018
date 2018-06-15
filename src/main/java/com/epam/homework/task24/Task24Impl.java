package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            result.computeIfPresent(entry.getKey(), (k, v) -> v + entry.getValue());
            result.computeIfAbsent(entry.getKey(), (v) -> entry.getValue());
        }

        return result;
    }
}
