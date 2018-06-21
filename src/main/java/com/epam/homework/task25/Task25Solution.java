package com.epam.homework.task25;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task25Solution implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        List<String> openBrackets = Arrays.asList("(", "[", "{");
        List<String> closeBrackets = Arrays.asList(")", "]", "}");
        Stack<String> stack = new Stack<>();
        for (String symbol : string.split("")) {

            if (openBrackets.contains(symbol)) {
                stack.push(symbol);
                continue;
            }
            if (closeBrackets.contains(symbol)) {
                if (stack.empty() || (openBrackets.indexOf(stack.pop()) != closeBrackets.indexOf(symbol))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
