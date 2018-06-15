package com.epam.homework.task25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Brackets implements Task25 {
    @Override
    public boolean isNormalBrackets(String string){
        String[] strAr = string.split("");
        List<String> openBrackets = Arrays.asList("(", "{", "[", "<");
        List<String> closeBrackets = Arrays.asList(")", "}", "]", ">");
        List<String> usedOpenBrackets = new ArrayList<>();

        for (String symbol : strAr) {
            if (openBrackets.contains(symbol)){
                usedOpenBrackets.add(0, symbol);
                continue;
            }
            if (closeBrackets.contains(symbol)){
                if (!usedOpenBrackets.isEmpty() && openBrackets.indexOf(usedOpenBrackets.get(0)) == closeBrackets.indexOf(symbol)){
                    usedOpenBrackets.remove(0);
                } else {
                    return false;
                }
            }
        }
        return usedOpenBrackets.isEmpty();
    }
}
