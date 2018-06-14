package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Task23Impl implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;

    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }
}

