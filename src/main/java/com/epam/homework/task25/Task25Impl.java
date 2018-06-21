package com.epam.homework.task25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        List<String> openBrackets = Arrays.asList("(", "[", "{");
        List<String> closeBrackets = Arrays.asList(")", "]", "}");

        Deque<String> usedOpenBrackets = new ArrayDeque<>();

        for (String ch : string.split("")) {
            if (openBrackets.contains(ch)) {
                usedOpenBrackets.push(ch);
                continue;
            }

            if (closeBrackets.contains(ch)) {
                if (usedOpenBrackets.isEmpty() || openBrackets.indexOf(usedOpenBrackets.pop()) != closeBrackets.indexOf(ch)) {
                    return false;
                }
            }
        }

        return usedOpenBrackets.isEmpty();
    }
}
