package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] input = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();

        int leftBound = 0;
        int rightBound = input.length - 1;

        while (leftBound < rightBound) {
            if (input[leftBound] != input[rightBound]) {
                return false;
            }
            leftBound++;
            rightBound--;
        }

        return true;
    }
}
