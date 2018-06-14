package com.epam.homework.task22;

import java.util.*;

public class Task22Impl implements Task22 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> allLinesOfTheAuthor = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                allLinesOfTheAuthor.addAll(poem.getLines());
            }
        }

        Collections.sort(allLinesOfTheAuthor, Comparator.comparingInt(String::length));

        return allLinesOfTheAuthor;
    }
}
