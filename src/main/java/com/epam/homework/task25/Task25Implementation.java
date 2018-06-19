package com.epam.homework.task25;

import java.util.regex.Pattern;

public class Task25Implementation implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        if (string.contains("(")) {
            return Pattern.matches("(.*)([^]\\[{}()]*\\))(.*)", string.substring(string.indexOf('(')));
        }
        if (string.contains("{")) {
            return Pattern.matches("(.*)([^]\\[{}()]*})(.*)", string.substring(string.indexOf('{')));
        }
        if (string.contains("[")) {
            return Pattern.matches("(.*)([^]\\[{}()]*])(.*)", string.substring(string.indexOf('[')));
        }
        return false;
    }
}
