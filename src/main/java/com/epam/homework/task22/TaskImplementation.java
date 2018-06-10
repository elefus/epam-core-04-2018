package com.epam.homework.task22;

import java.util.*;
import java.util.stream.Collectors;

public class TaskImplementation implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        return poems.stream()
                .filter(iPoem -> iPoem.getAuthor().equals(author))
                .flatMap(iPoem -> iPoem.getLines().stream())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}