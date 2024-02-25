package com.hsbc.candycrushletter;

import java.util.Stack;


/**
 * using Dynamic Programming to solve the problem.
 * characters are identical, remove them from the string.
 */
public class RemoveStrategy implements BaseStrategy {
    @Override
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 3) return s.toString();
        if(s.chars().distinct().allMatch(c->c==s.charAt(0))) return null;
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            builder.append(c);
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            } else {
                if(stack.size()>=3){
                    builder.delete((builder.length() - stack.size()-1), builder.length()-1);
                }
                stack.clear();
                stack.push(c);
            }
        }
        return builder.toString().equals(s)?builder.toString():removeDuplicates(builder.toString());
    }
}
