package com.exercises.leetcode.strings.easy;

import java.util.HashMap;

@SuppressWarnings("unused")
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] sequence = s.toCharArray();
        int firstUnique = -1;

        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < sequence.length; i++) {
            counter.put(sequence[i], counter.getOrDefault(sequence[i], 0) + 1);
        }

        for (int i = 0; i < sequence.length; i++) {
            if (counter.get(sequence[i]) == 1) {
                firstUnique = i;
                break;
            }
        }

        return firstUnique;
    }
}
