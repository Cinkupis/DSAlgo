package com.algorithms.strings;

@SuppressWarnings("unused")
public class FirstOccurenceMPAlgorithm {
    public int strStr(String bigText, String patternToFind) {
        if (bigText == null || patternToFind == null || bigText.length() < patternToFind.length()) {
            return -1;
        }

        if (patternToFind.isEmpty() || bigText.equals(patternToFind)) {
            return 0;
        }

        char[] text = bigText.toCharArray();
        char[] pattern = patternToFind.toCharArray();

        int[] MP_next = precomputeBorders(pattern);

        return MP_Algorithm(text, pattern, MP_next);
    }

    private int[] precomputeBorders(char[] pattern) {
        int[] MP_next = new int[pattern.length + 1];
        MP_next[0] = -1;
        for (int patternIndex = 0; patternIndex < pattern.length; patternIndex++) {
            int borderLength = MP_next[patternIndex];
            while (borderLength >= 0 && pattern[patternIndex] != pattern[borderLength]) {
                borderLength = MP_next[borderLength];
            }
            MP_next[patternIndex + 1] = borderLength + 1;
        }
        return MP_next;
    }

    private int MP_Algorithm(char[] text, char[] pattern, int[] MP_next) {
        int patternIndex = 0;
        int textIndex = 0;

        while (textIndex < text.length) {
            while (patternIndex == pattern.length || (patternIndex >= 0 && pattern[patternIndex] != text[textIndex])) {
                patternIndex = MP_next[patternIndex];
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
