package com.exercises.leetcode.strings.easy;

import java.util.HashMap;

@SuppressWarnings("unused")
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] seq = s.toCharArray();
        int length = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < seq.length; i++) {
            if (!map.containsKey(seq[i]) || map.get(seq[i]) < start) {
                map.put(seq[i], i + 1);
            } else {
                if (i - start> length) {
                    length = i - start;
                }
                start = map.get(seq[i]);
                map.put(seq[i], i + 1);
            }
        }
        return seq.length - start > length ? seq.length - start : length;
    }
}
