package com.exercises.leetcode.arrays.medium;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peek()];
                resultIndex++;
            }
        }
        return result;
    }
}
