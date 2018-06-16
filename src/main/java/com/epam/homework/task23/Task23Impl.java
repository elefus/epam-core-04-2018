package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Impl implements Task23 {

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> setIntersection = new HashSet<>();
        for (Integer i : first) {
            if (second.contains(i)) {
                setIntersection.add(i);
            }
        }
        return setIntersection;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> setUnion = new HashSet<>();
        setUnion.addAll(first);
        setUnion.addAll(second);
        return setUnion;
    }
}
