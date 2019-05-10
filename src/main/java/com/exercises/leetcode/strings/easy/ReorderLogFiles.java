package com.exercises.leetcode.strings.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int s1space = s1.indexOf(' ');
            int s2space = s2.indexOf(' ');
            char s1firstChar = s1.charAt(s1space + 1);
            char s2firstChar = s2.charAt(s2space + 1);

            if (s1firstChar <= '9') {
                if (s2firstChar <= '9') {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (s2firstChar <= '9') {
                return -1;
            }

            int preCompute = s1.substring(s1space + 1).compareTo(s2.substring(s2space + 1));
            if (preCompute == 0) {
                return s1.substring(0, s1space).compareTo(s2.substring(0, s2space));
            }
            return preCompute;
        });
        return logs;
    }
}
