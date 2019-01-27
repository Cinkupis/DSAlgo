package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class FirstOccurenceMPAlgorithm {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        }

        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] MP_next = precomputeBorders(pattern);

        return MP_Algorithm(text, pattern, MP_next);
    }

    private int[] precomputeBorders(char[] pattern) {
        int[] MP_next = new int[pattern.length + 1];
        MP_next[0] = -1;
        for (int i = 0; i < pattern.length; i++) {
            int j = MP_next[i];
            while (j >= 0 && pattern[i] != pattern[j]) {
                j = MP_next[j];
            }
            MP_next[i + 1] = j + 1;
        }
        return MP_next;
    }

    private int MP_Algorithm(char[] text, char[] pattern, int[] MP_next) {
        int i = 0;
        int j = 0;

        while (j < text.length) {
            while (i == pattern.length || (i >= 0 && pattern[i] != text[j])) {
                i = MP_next[i];
            }
            i++;
            j++;
            if (i == pattern.length) {
                return j - i;
            }
        }
        return -1;
    }
}
