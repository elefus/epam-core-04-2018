package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Impl implements Task23 {

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {

        Set<Integer> intersection = new HashSet<>();

        for (Integer item : first) {
            if (second.contains(item)) {
                intersection.add(item);
            }
        }

        return intersection;

    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {

        Set<Integer> union = new HashSet<>(first);
        union.addAll(second);
        return union;

    }

}
