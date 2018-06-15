package com.epam.homework.task25;

public class Task25Impl implements Task25{

    @Override
    public boolean isNormalBrackets(String string) {
        return string.replaceAll("\\(.*?\\)", "").matches("^[^\\(\\)]*$");
    }
}
