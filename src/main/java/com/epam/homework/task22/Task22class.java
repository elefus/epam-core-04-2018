package com.epam.homework.task22;

import lombok.Data;

import java.util.*;

public class Task22class implements Task22 {

    public static void main(String[] args) {
        NewPairAuthorAndPoem author1 = new NewPairAuthorAndPoem();
        author1.setAuthor("author1");
        author1.setLines(Arrays.asList("First line", "Second line", "Five lines"));
        NewPairAuthorAndPoem author2 = new NewPairAuthorAndPoem();
        author2.setAuthor("author2");
        author2.setLines(Arrays.asList("First line of author2", "Second line of author2", "Five lines of author2"));
        NewPairAuthorAndPoem author3 = new NewPairAuthorAndPoem();
        author3.setAuthor("author1");
        author3.setLines(Arrays.asList("Three line", "Five line", "gan-gnam style"));
        Set<IPoem> poems = new HashSet<>();
        poems.add(author1);
        poems.add(author2);
        poems.add(author3);
        Task22 obj = new Task22class();
        List <String> poemsLines = obj.sortPoems(poems, "author1");
        for (String poemsLine : poemsLines) {
            System.out.println(poemsLine);
        }
    }

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> authorPoems = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                 authorPoems.addAll(poem.getLines());
            }
        }
        authorPoems.sort(Comparator.comparingInt(String::length));
        return authorPoems;
    }

    @Data
    static class NewPairAuthorAndPoem implements IPoem {
        String author;
        List<String> lines;
    }



}
