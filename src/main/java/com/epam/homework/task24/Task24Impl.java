package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task24Impl implements Task24 {

    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>(first);
        Set<Integer> keys = second.keySet();
        for (Integer key : keys) {
            Integer currentValue = result.get(key);
            if (currentValue == null) {
                result.put(key, second.get(key));
            } else {
                result.put(key, currentValue + second.get(key));
            }
        }
        return result;
    }
}
