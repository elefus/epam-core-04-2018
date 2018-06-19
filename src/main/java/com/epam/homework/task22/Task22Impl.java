package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class Task22Impl implements Task22 {


    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> sortedPoems = new ArrayList<>();
        poems.forEach(iPoem -> {
            if (iPoem.getAuthor().equals(author)) {
                sortedPoems.addAll(iPoem.getLines());
            }
        });
        Collections.sort(sortedPoems);
        return sortedPoems;
    }

}
