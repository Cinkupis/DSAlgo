package com.exercises.leetcode.mathpuzzles.easy;

@SuppressWarnings("unused")
public class ReverseInteger {
    public int reverse(int x) {
        int numberOfDigits = 0;
        int number = x;
        while (Math.abs(number) > 0) {
            numberOfDigits++;
            number /= 10;
        }

        number = x;
        int result = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            int lastDigit = number % 10;
            result += lastDigit * Math.pow(10, numberOfDigits - 1 - i);
            number = number / 10;
        }

        if (result == Integer.MAX_VALUE || result == Integer.MIN_VALUE) {
            return 0;
        }

        return result;
    }
}
