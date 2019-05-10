package com.exercises.leetcode.strings.easy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z ]", " ").split(" ");
        Map<String, Integer> bag = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                bag.put(words[i], bag.getOrDefault(words[i], 0) + 1);
            }
        }
        for (int i = 0; i < banned.length; i++) {
            bag.remove(banned[i]);
        }
        String common = null;
        int count = 0;
        for (Map.Entry<String, Integer> entry : bag.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                common = entry.getKey();
            }
        }
        return common;
    }
}
