package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class ReverseAString {
    public void reverseString(char[] s) {
        int leftBound = 0;
        int rightBound = s.length - 1;

        while (leftBound < rightBound) {
            char temp = s[leftBound];
            s[leftBound] = s[rightBound];
            s[rightBound] = temp;

            leftBound++;
            rightBound--;
        }
    }
}
