package com.exercises.leetcode.strings.medium;

@SuppressWarnings("unused")
public class LongestPalindromicSubstring {
    private int palinStart = 0;
    private int palinEnd = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(palinStart, palinStart + palinEnd);
    }

    private void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (palinEnd < end - start - 1) {
            palinStart = start + 1;
            palinEnd = end - start - 1;
        }
    }
}
