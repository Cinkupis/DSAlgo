package com.exercises.leetcode.arrays.easy;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (pQueue.size() < k) {
                pQueue.offer(nums[i]);
            } else if (nums[i] >= pQueue.peek()) {
                pQueue.poll();
                pQueue.offer(nums[i]);
            }
        }
        return pQueue.poll();
    }
}
