package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Impl implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersectionSet = new HashSet<>();
        for (Integer cur: first) {
            if(second.contains(cur)){
                intersectionSet.add(cur);
            }
        }
        return intersectionSet;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> unionSet = new HashSet<>();
        unionSet.addAll(first);
        unionSet.addAll(second);
        return unionSet;
    }
}
