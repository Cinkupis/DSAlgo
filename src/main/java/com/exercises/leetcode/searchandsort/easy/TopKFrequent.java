package com.exercises.leetcode.searchandsort.easy;

import java.util.*;

@SuppressWarnings("unused")
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> freq.get(b) - freq.get(a));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            queue.offer(entry.getKey());
        }

        while (k > 0) {
            result.add(queue.poll());
            k--;
        }
        return result;
    }
}
