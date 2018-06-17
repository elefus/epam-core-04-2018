package com.epam.homework.task25;

import java.util.Stack;

public class Task25Impl implements Task25 {

    private static String brackets = "{}()[]";

    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : string.toCharArray()) {
            int index = brackets.indexOf(ch);
            if (index > 0) {
                if (brackets.indexOf(ch) % 2 != 0) {
                    if (!stack.isEmpty() && stack.peek() == brackets.charAt(index - 1)) {
                        stack.pop();
                    } else {
                        stack.add(ch);
                    }
                } else {
                    stack.add(ch);
                }
            }
        }
        return stack.isEmpty();
    }
}
