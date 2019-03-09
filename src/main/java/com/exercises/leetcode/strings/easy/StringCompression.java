package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        char letter = chars[0];
        int count = 1;
        int index = 0;

        for (int i = 1; i < chars.length + 1; i++) {
            if (i < chars.length && chars[i] == letter) {
                count++;
            } else {
                chars[index++] = letter;
                if (i < chars.length) {
                    letter = chars[i];
                }
                if (count > 1) {
                    for (char digit : Integer.toString(count).toCharArray()) {
                        chars[index++] = digit;
                    }
                }
                count = 1;
            }
        }

        return index;
    }
}
