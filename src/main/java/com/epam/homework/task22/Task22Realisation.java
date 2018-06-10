package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Task22Realisation implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> resultList = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                resultList.addAll(poem.getLines());
            }
        }
        Collections.sort(resultList);
        return resultList;
    }
}
