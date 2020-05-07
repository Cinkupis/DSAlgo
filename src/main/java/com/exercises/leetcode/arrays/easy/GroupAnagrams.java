package com.exercises.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            List<String> list = hashMap.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            hashMap.put(sorted, list);
        }

        return new ArrayList<>(hashMap.values());
    }
}
