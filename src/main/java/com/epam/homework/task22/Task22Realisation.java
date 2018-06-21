package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Task22Realisation implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> sortedList = new ArrayList<>();
        for (IPoem ipoem : poems) {
            if (ipoem.getAuthor().equals(author)) {
                sortedList.addAll(ipoem.getLines());
            }
        }
        Collections.sort(sortedList);
        return sortedList;
    }
}