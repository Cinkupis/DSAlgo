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

        for (int i = 0; i < exprArray.length; i++) {
            if (exprArray[i] >= '0' && exprArray[i] <= '9') {
                if (currNumber == null) {
                    currNumber = exprArray[i] - '0';
                } else {
                    currNumber = currNumber * 10 + exprArray[i] - '0';
                }
            } else {
                numbers.add(currNumber);
                currNumber = null;
                operators.add(exprArray[i]);
            }
        }

        numbers.add(currNumber);

        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*') {
                numbers.set(i, numbers.get(i) * numbers.get(i + 1));
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            } else if (operators.get(i) == '/') {
                numbers.set(i, (int) numbers.get(i) / numbers.get(i + 1));
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

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
