package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class StringToInteger {
    public int myAtoi(String str) {
        char[] input = str.toCharArray();
        int startFrom = 0;
        int result = 0;

        while (startFrom < input.length && input[startFrom] == ' ') {
            startFrom++;
        }

        if (startFrom >= input.length) {
            return result;
        }

        int sign = 1;
        if (input[startFrom] == '-') {
            sign = -1;
            startFrom++;
        } else if (input[startFrom] == '+') {
            startFrom++;
        }
        if (startFrom >= input.length) {
            return result;
        }

        for (int i = startFrom; i < input.length && input[i] >= '0' && input[i] <= '9'; i++) {
            int currNumber = input[i] - '0';
            int newResult = result * 10 + currNumber;
            if ((newResult - currNumber) / 10 != result || newResult < 0) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = newResult;
        }
        return sign * result;
    }
}
