package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class ReverseWordsInAString2 {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0;
        int end = 0;
        while (end <= str.length) {
            if (end == str.length || str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
            end++;
        }
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
