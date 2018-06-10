package com.epam.homework.task22;

import java.util.ArrayList;
import java.util.List;

public class IPoemImpl implements Task22.IPoem {

    private List<String> poem = new ArrayList<>();
    private String fileName;
    private String author;

    @Override
    public List<String> getLines() {
        return poem;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
