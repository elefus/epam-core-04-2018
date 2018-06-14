package com.epam.homework.task22;

import java.util.*;

public class SortPoems implements Task22 {
    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     *
     * @param poems  Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> result = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                result.addAll(poem.getLines());
            }
        }
        result.sort(Comparator.comparingInt(String::length));
        return result;
    }


    class Poem implements IPoem {

        private List<String> lines = new ArrayList<>();
        private String author;

        Poem(List<String> list, String author) {
            lines = list;
            this.author = author;
        }

        /**
         * @return Список строк, составляющих стихотворение.
         */
        @Override
        public List<String> getLines() {
            return lines;
        }

        /**
         * @return Автор стихотворения.
         */
        @Override
        public String getAuthor() {
            return author;
        }
    }
}
