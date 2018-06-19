package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Impl implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> temp = new HashSet<>(first);
        temp.retainAll(second);
        return temp;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> temp = new HashSet<>(first);
        temp.addAll(second);
        return temp;
    }
}
