package com.epam.homework.task25;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task25Realisation implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        List<String> openingBrackets = Arrays.asList("(", "{", "[");
        List<String> closingBrackets = Arrays.asList(")", "}", "]");
        Stack<String> stack = new Stack<>();
        for (String curr : string.split("")) {
            if (openingBrackets.contains(curr)) {
                stack.push(curr);
                continue;
            }
            if (closingBrackets.contains(curr)) {
                if (stack.empty() || (openingBrackets.indexOf(stack.pop()) != closingBrackets.indexOf(curr))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
