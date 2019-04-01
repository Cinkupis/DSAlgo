package com.exercises.leetcode.dynamicprogramming.easy;

@SuppressWarnings("unused")
public class MaximumSubArrayDivideAndConquer {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int maxSubArrayDivideAndConquer(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return nums[lowIndex];
        }

        int midIndex = (lowIndex + highIndex) / 2;
        return Math.max(Math.max(maxSubArrayDivideAndConquer(nums, lowIndex, midIndex),
                maxSubArrayDivideAndConquer(nums, midIndex + 1, highIndex)),
                maxCrossingSum(nums, lowIndex, midIndex, highIndex));
    }

    private int maxCrossingSum(int[] nums, int lowIndex, int midIndex, int highIndex) {
        int sumSoFar = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = midIndex; i >= lowIndex; i--) {
            sumSoFar = sumSoFar + nums[i];
            if (sumSoFar > leftSum) {
                leftSum = sumSoFar;
            }
        }

        sumSoFar = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = midIndex + 1; i <= highIndex; i++) {
            sumSoFar = sumSoFar + nums[i];
            if (sumSoFar > rightSum) {
                rightSum = sumSoFar;
            }
        }

        return leftSum + rightSum;
    }
}
