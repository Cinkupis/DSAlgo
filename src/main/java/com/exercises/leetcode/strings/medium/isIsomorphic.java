package com.exercises.leetcode.strings.medium;

import java.util.HashMap;

@SuppressWarnings("unused")
public class isIsomorphic {
    public boolean isIsomorphic(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }

        if (firstString.length() != secondString.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0; i < firstString.length(); i++) {
            char c1 = firstString.charAt(i);
            char c2 = secondString.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }
}
