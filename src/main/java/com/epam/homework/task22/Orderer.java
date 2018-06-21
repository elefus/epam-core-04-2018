package com.epam.homework.task22;

import java.util.*;

public class Orderer implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> authorLines = getAuthorLines(poems, author);
        authorLines.sort(Comparator.comparingInt(String::length));

        return authorLines;
    }

    private List<String> getAuthorLines(Set<IPoem> poems, String author) {
        List<String> authorLines = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                authorLines.addAll(poem.getLines());
            }
        }

        return authorLines;
    }
}
