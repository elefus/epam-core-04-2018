package com.epam.homework.task25;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Brackets implements Task25 {
    @Override
    public boolean isNormalBrackets(String string){
        String[] strAr = string.split("");
        List<String> openBrackets = Arrays.asList("(", "{", "[", "<");
        List<String> closeBrackets = Arrays.asList(")", "}", "]", ">");
        Stack<String> usedOpenBrackets = new Stack<>();

        for (String symbol : strAr) {
            if (openBrackets.contains(symbol)){
                usedOpenBrackets.push(symbol);
                continue;
            }
            if (closeBrackets.contains(symbol)){
                if (!usedOpenBrackets.empty() && openBrackets.indexOf(usedOpenBrackets.peek()) == closeBrackets.indexOf(symbol)){
                    usedOpenBrackets.pop();
                } else {
                    return false;
                }
            }
        }
        return usedOpenBrackets.empty();
    }
}
