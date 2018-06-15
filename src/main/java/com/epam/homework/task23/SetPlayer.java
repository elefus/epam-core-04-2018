package com.epam.homework.task23;

import com.sun.xml.internal.ws.protocol.soap.ServerMUTube;

import java.util.HashSet;
import java.util.Set;

public class SetPlayer implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new HashSet<>();

        for (Integer el : first) {
            if (second.contains(el)) {
                intersection.add(el);
            }
        }

        return intersection;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new HashSet<>();

        union.addAll(first);
        union.addAll(second);

        return union;
    }
}
