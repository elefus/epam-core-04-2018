package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Polynomials implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second){
        Map<Integer, Integer> union = new HashMap<>(first);

        for (Integer keyOfSecond : second.keySet()) {
            if (union.containsKey(keyOfSecond)){
                union.put(keyOfSecond, first.get(keyOfSecond) + second.get(keyOfSecond));
            } else {
                union.put(keyOfSecond, second.get(keyOfSecond));
            }
        }
        return union;
    }
}
