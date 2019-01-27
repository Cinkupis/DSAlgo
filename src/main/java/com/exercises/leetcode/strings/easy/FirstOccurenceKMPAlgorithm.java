package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class FirstOccurenceKMPAlgorithm {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        }

        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] KMP_next = precomputeKMP(pattern);

        return KMP_Algorithm(text, pattern, KMP_next);
    }

    private int[] precomputeKMP(char[] pattern) {
        int[] KMP_next = new int[pattern.length + 1];
        KMP_next[0] = -1;
        int k = 0;
        for (int i = 1; i < pattern.length; i++) {
            if (pattern[i] == pattern[k]) {
                KMP_next[i] = KMP_next[k];
            } else {
                KMP_next[i] = k;
                do {
                    k = KMP_next[k];
                } while (k >= 0 && pattern[i] != pattern[k]);
            }
            k++;
        }
        KMP_next[pattern.length] = k;
        return KMP_next;
    }

    private int KMP_Algorithm(char[] text, char[] pattern, int[] KMP_next) {
        int i = 0;
        int j = 0;

        while (j < text.length) {
            while (i == pattern.length || (i >= 0 && pattern[i] != text[j])) {
                i = KMP_next[i];
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
