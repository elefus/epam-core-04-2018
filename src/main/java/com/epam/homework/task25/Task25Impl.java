package com.epam.homework.task25;

import java.util.Stack;

public class Task25Impl implements Task25 {

    @Override
    public boolean isNormalBrackets(String string) {

        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < string.length(); i++){
            Character c = string.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    brackets.push(c);
                    break;
                case ')':
                    if (brackets.isEmpty() || !"(".equals(brackets.pop().toString())) {
                        return false;
                    }
                    break;
                case ']':
                    if (brackets.isEmpty() || !"[".equals(brackets.pop().toString())) {
                        return false;
                    }
                    break;
                case '}':
                    if (brackets.isEmpty() || !"{".equals(brackets.pop().toString())) {
                        return false;
                    }
                    break;
            }
        }

        return brackets.isEmpty();

    }

}
