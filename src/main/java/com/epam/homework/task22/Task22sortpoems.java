package com.epam.homework.task22;

import java.util.*;


public class Task22sortpoems implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> listOfPoems = new ArrayList<>();
        for (Iterator<IPoem> iterator = poems.iterator(); iterator.hasNext(); ) {
            IPoem iPoem = iterator.next();
            if (iPoem.getAuthor().equals(author)) {
                listOfPoems.addAll(iPoem.getLines());
            }
        }
        listOfPoems.sort(Comparator.comparingInt(String::length));
        return listOfPoems;
    }
}
