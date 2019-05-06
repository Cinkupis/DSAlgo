package com.exercises.leetcode.arrays.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class MaximumSizeSubarrayContainsKDistinctElements {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        int j = 0;

        while (j < tree.length) {
            map.put(tree[j], j);
            if (map.size() > 2) {
                int min = tree.length - 1;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                map.remove(tree[min]);
            }
            j++;
            max = Math.max(max, j - i);
        }
        return max;
    }
}
