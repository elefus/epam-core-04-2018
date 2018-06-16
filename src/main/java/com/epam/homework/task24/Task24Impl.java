package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> polynomialsAdditionResult = new HashMap<>();

        for (Integer key : first.keySet()) {
            polynomialsAdditionResult.put(key, first.get(key) + second.get(key));
        }

        for (Integer key : second.keySet()) {
            if (!first.containsKey(key)) {
                polynomialsAdditionResult.put(key, second.get(key));
            }
        }

        return polynomialsAdditionResult;
    }
}
