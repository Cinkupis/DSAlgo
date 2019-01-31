package com.exercises.leetcode.dynamicprogramming.easy;

@SuppressWarnings("unused")
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int previous = 0;
        int sumSoFar = 0;
        for (int number : nums) {
            int temp = sumSoFar;
            sumSoFar = Math.max(previous + number, sumSoFar);
            previous = temp;
        }

        return sumSoFar;
    }
}
