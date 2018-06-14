package com.epam.homework.task22;

import java.util.*;

public class Task22Impl implements Task22 {


    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> listPoems = new ArrayList<>();
        for (IPoem iPoem : poems){
            if (iPoem.getAuthor().equals(author)){
                listPoems.addAll(iPoem.getLines());
            }
        }
        listPoems.sort(Comparator.comparingInt(String::length));
        return listPoems;
    }
}
