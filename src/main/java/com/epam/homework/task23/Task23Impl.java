package com.epam.homework.task23;

import java.util.Set;

public class Task23Impl implements Task23 {

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        first.retainAll(second);
        return first;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        first.addAll(second);
        return first;
    }
}
