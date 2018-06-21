package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24 {

    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {

        Map<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), (val1, val2) -> val1 + val2);
        }

        return result;
    }

}
