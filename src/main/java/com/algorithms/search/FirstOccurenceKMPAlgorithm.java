package com.algorithms.search;

@SuppressWarnings("unused")
public class FirstOccurenceKMPAlgorithm {
    public int strStr(String bigText, String patternToFind) {
        if (bigText == null || patternToFind == null || bigText.length() < patternToFind.length()) {
            return -1;
        }

        if (patternToFind.isEmpty() || bigText.equals(patternToFind)) {
            return 0;
        }

        char[] text = bigText.toCharArray();
        char[] pattern = patternToFind.toCharArray();

        int[] KMP_next = precomputeKMP(pattern);

        return KMP_Algorithm(text, pattern, KMP_next);
    }

    private int[] precomputeKMP(char[] pattern) {
        int[] KMP_next = new int[pattern.length + 1];

        KMP_next[0] = -1;
        int trailingIndex = 0;
        for (int patternIndex = 1; patternIndex < pattern.length; patternIndex++) {
            if (pattern[patternIndex] == pattern[trailingIndex]) {
                KMP_next[patternIndex] = KMP_next[trailingIndex];
            } else {
                KMP_next[patternIndex] = trailingIndex;
                do {
                    trailingIndex = KMP_next[trailingIndex];
                } while (trailingIndex >= 0 && pattern[patternIndex] != pattern[trailingIndex]);
            }
            trailingIndex++;
        }
        KMP_next[pattern.length] = trailingIndex;
        return KMP_next;
    }

    private int KMP_Algorithm(char[] text, char[] pattern, int[] KMP_next) {
        int patternIndex = 0;
        int textIndex = 0;

        while (textIndex < text.length) {
            while (patternIndex == pattern.length || (patternIndex >= 0 && pattern[patternIndex] != text[textIndex])) {
                patternIndex = KMP_next[patternIndex];
            }
            patternIndex++;
            textIndex++;
            if (patternIndex == pattern.length) {
                return textIndex - patternIndex;
            }
        }
        return -1;
    }
}
