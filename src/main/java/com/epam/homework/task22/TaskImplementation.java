package com.epam.homework.task22;

import java.util.*;
import java.util.stream.Collectors;

public class TaskImplementation implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                return poem.getLines().stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }
}