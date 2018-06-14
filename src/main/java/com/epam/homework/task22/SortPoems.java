package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SortPoems implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author){
        List<String> sortPoems = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)){
                sortPoems.addAll(poem.getLines());
            }
        }
        sortPoems.sort(((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length()));

        return sortPoems;
    }
}
