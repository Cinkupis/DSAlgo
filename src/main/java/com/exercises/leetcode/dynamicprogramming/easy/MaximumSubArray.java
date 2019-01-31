package com.exercises.leetcode.dynamicprogramming.easy;

@SuppressWarnings("unused")
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int currentSum = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }

        return maxSoFar;
    }
}
