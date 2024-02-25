package com.hsbc.candycrushletter;

import java.util.Stack;

/**
 * using Dynamic Programming to solve the problem.
 * if the duplicate element is a then remove all, or else remove all,only left a element which will be replace by a
 * single character that comes before it alphabetically.
 */
public class ReplaceStrategy implements BaseStrategy {
    @Override
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 3) return s.toString();
        if (s.chars().distinct().allMatch(c -> (c == s.charAt(0) && c == 97))) return null;
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            builder.append(c);
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            } else {
                checkDuplicateNumMoreThan3(stack, builder);
                stack.clear();
                stack.push(c);
            }
        }
        return builder.toString().equals(s) ? builder.toString() : removeDuplicates(builder.toString());
    }

    private void checkDuplicateNumMoreThan3(Stack<Character> stack, StringBuilder builder) {
        if (stack.size() >= 3) {
            if (builder.charAt(builder.length() - 2) == 97) {
                removeDuplicateA(stack, builder);
            } else {
                removeAndReplace(stack, builder);
            }
        }
    }

    private void removeAndReplace(Stack<Character> stack, StringBuilder builder) {
        builder.delete((builder.length() - stack.size()), builder.length() - 1);
        builder.replace(builder.length() - 2, builder.length() - 1, String.valueOf((char) (builder.charAt(builder.length() - 2) - 1)));
    }

    private void removeDuplicateA(Stack<Character> stack, StringBuilder builder) {
        builder.delete((builder.length() - stack.size() - 1), builder.length() - 1);
    }
}
