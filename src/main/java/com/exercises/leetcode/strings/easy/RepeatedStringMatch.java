package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int repeats = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            repeats++;
        }
        if (sb.toString().contains(B)) {
            return repeats;
        }
        if (sb.append(A).toString().contains(B)) {
            return repeats + 1;
        }
        return -1;
    }
}
