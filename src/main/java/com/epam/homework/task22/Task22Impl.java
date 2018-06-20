package com.epam.homework.task22;

import java.util.*;
import java.util.stream.Collectors;

public class Task22Impl implements Task22 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        return poems.stream()
                .filter(poem -> poem.getAuthor().equals(author))
                .flatMap(poem -> poem.getLines().stream())
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}