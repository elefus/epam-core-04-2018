package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> answer = new HashMap<>(first);

        for (Integer currentKey : second.keySet()) {
            if (answer.containsKey(currentKey)) {
                answer.put(currentKey, first.get(currentKey) + second.get(currentKey));
            } else {
                answer.put(currentKey, second.get(currentKey));
            }
        }
        return answer;
    }
}
