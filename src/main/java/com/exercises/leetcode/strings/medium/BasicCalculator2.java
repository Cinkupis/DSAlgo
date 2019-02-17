package com.exercises.leetcode.strings.medium;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class BasicCalculator2 {
    public int calculate(String s) {
        String expression = s.replace(" ", "");
        char[] exprArray = expression.toCharArray();
        List<Integer> numbers = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Integer currNumber = null;

        int index = 0;
        while (index < operators.size()) {
            if (operators.get(index) == '*' || operators.get(index) == '/') {
                if (operators.get(index) == '*') {
                    numbers.set(index, numbers.get(index) * numbers.get(index + 1));
                } else {
                    numbers.set(index, (int) numbers.get(index) / numbers.get(index + 1));
                }
                numbers.remove(index + 1);
                operators.remove(index);
            } else {
                index++;
            }
        }
        numbers.add(currNumber);

        if (operators.size() == 0) {
            return numbers.get(0);
        }

        while (operators.size() > 0) {
            if (operators.get(0) == '+') {
                numbers.set(0, numbers.get(0) + numbers.get(1));
            } else if (operators.get(0) == '-') {
                numbers.set(0, numbers.get(0) - numbers.get(1));
            }
            numbers.remove(1);
            operators.remove(0);
        }

        return numbers.get(0);
    }
}
