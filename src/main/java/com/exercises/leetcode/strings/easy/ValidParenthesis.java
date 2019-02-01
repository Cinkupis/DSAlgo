package com.exercises.leetcode.strings.easy;

import java.util.Stack;

@SuppressWarnings("unused")
public class ValidParenthesis {
    public boolean isValid(String s) {
        // First In - First Out
        // If you found ( / [ / {, then you push the opposite;
        // If you found the opposite, then the first to pop out from the stack
        // MUST be the char you found.
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
