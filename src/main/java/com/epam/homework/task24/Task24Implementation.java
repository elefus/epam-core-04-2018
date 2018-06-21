package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Implementation implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> resultMap = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry: second.entrySet()) {
            resultMap.merge(entry.getKey(), entry.getValue(), (val1, val2) -> val1 + val2);
        }
        return resultMap;
    }
}
