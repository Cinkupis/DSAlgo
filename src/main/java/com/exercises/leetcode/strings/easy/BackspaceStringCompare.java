package com.exercises.leetcode.strings.easy;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int skip = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                queue.offer(s[i]);
            }
        }

        skip = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else if (queue.isEmpty() || t[i] != queue.poll()) {
                return false;
            }
        }

        return queue.isEmpty();
    }
}
