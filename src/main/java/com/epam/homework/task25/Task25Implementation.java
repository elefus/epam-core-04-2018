package com.epam.homework.task25;

import java.util.*;

public class Task25Implementation implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char lt : string.toCharArray()) {
            switch (lt) {
                case '{':
                case '[':
                case '(':
                    stack.push(lt);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((lt == '}' && chx != '{') || (lt == ']' && chx != '[')
                                || (lt == ')' && chx != '('))
                            return false;
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}