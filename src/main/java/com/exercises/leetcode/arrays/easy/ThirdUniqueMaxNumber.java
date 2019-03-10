package com.exercises.leetcode.arrays.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@SuppressWarnings("unused")
public class ThirdUniqueMaxNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniques.contains(nums[i])) {
                heap.offer(nums[i]);
                uniques.add(nums[i]);
                if (heap.size() > 3) {
                    uniques.remove(heap.poll());
                }
            }
        }

        if (heap.size() == 2) {
            heap.poll();
        }

        return heap.peek();
    }
}
