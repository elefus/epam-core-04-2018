package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Task22Performance implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> currentPoem, String author) {
        List<String> result = new ArrayList<>();
        for (IPoem poem : currentPoem) {
            if (poem.getAuthor().equals(author)) {
                result.addAll(poem.getLines());
            }
        }
        Collections.sort(result);
        return result;
    }
}
