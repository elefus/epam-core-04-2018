package com.epam.homework.task24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Set<Integer> powers = new HashSet<>();
        Map<Integer, Integer> result = new HashMap<>();
        powers.addAll(first.keySet());
        powers.addAll(second.keySet());
        for (Integer pow : powers) {
            Integer a = 0;
            Integer b = 0;
            if (first.get(pow) != null) {
                a = first.get(pow);
            }
            if (second.get(pow) != null) {
                b = second.get(pow);
            }
            result.put(pow, a + b);
        }

        return result;
    }
}
