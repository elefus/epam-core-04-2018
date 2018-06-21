package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task22Impl implements Task22 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> poemsByAuthor = new ArrayList<>();
        for (IPoem poem : poems) {
            if (author.equals(poem.getAuthor())) {
                poemsByAuthor.addAll(poem.getLines());
            }
        }
        poemsByAuthor.sort(Comparator.comparingInt(String::length));
        return poemsByAuthor;
    }
}
