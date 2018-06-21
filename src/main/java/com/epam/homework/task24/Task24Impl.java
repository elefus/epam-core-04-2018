package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> additionResult = new HashMap<>(first);
        for (Integer curKey: second.keySet()) {
            Integer inputValue = additionResult.containsKey(curKey) ?
                    additionResult.get(curKey) + second.get(curKey) : second.get(curKey);
            additionResult.put(curKey, inputValue);
        }
        return additionResult;
    }
}
