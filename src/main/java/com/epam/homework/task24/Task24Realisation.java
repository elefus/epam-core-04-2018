package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task24Realisation implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>(first);
        Set<Integer> keysSet = second.keySet();
        for (Integer i : keysSet) {
            Integer curr = result.get(i);
            if (curr == null) {
                result.put(i, second.get(i));
                } else {
                result.put(i, curr + second.get(i));
            }
        }
        return result;
    }
}
