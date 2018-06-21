package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Realisation implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersectionSet = new HashSet<>(first);
        intersectionSet.retainAll(second);
        return intersectionSet;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> unionSet = new HashSet<>(first);
        unionSet.addAll(second);
        return unionSet;
    }
}
