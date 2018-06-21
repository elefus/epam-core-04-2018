package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Implementation implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {

        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.retainAll(second);
        return resultSet;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {

        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.addAll(second);
        return resultSet;
    }
}

