package com.epam.homework.task22;

import java.util.*;

public class Task22Impl implements Task22{
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> result = new ArrayList<>();
        for (IPoem poem : poems) {
            if(poem.getAuthor().equals(author)){
                result.addAll(poem.getLines());
            }
        }

        result.sort(Comparator.comparingInt(String::length));

        return result;
    }
}
