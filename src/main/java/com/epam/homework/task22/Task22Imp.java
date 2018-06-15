package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task22Imp implements Task22 {
    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     *
     * @param poems  Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> list = new ArrayList<>();

        for (IPoem poem : poems) {
            if (author.equals(poem.getAuthor())) {
                list.addAll(poem.getLines());
            }

        }
        list.sort(Comparator.comparingInt(String::length));


        return list;
    }
}

