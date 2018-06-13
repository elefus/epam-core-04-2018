package com.epam.homework.task22;

import lombok.Data;

import java.util.*;

public class Task22class implements Task22 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> authorPoems = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                 authorPoems.addAll(poem.getLines());
            }
        }
        Comparator<String> length = Comparator.comparingInt(String::length);
        authorPoems.sort(length);
        return authorPoems;
    }

    @Data
    class NewPairAuthorAndPoem implements IPoem {
        String author;
        List<String> lines;
    }



}
