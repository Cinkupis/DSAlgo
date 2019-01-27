package com.exercises.leetcode.strings.easy;

import java.util.HashMap;

@SuppressWarnings("unused")
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sCounter = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();

        if (s.length() != t.length()) {
            return false;
        }

        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        char[] sSequence = s.toCharArray();
        char[] tSequence = t.toCharArray();

        for (int i = 0; i < sSequence.length; i++) {
            sCounter.put(sSequence[i], sCounter.getOrDefault(sSequence[i], 0) + 1);
            tCounter.put(tSequence[i], tCounter.getOrDefault(tSequence[i], 0) + 1);
        }

        for (char c : sSequence) {
            if (!sCounter.get(c).equals(tCounter.get(c))) {
                return false;
            }
        }

        return true;
    }
}
