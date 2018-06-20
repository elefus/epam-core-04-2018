package com.epam.homework.task24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> keySet = new HashSet<>();
        keySet.addAll(first.keySet());
        keySet.addAll(second.keySet());
        keySet.stream().forEach(key -> result.put(key, first.getOrDefault(key, 0) + second.getOrDefault(key, 0)));
        return result;
    }
}