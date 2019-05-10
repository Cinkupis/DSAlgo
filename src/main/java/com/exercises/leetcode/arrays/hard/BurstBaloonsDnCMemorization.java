package com.exercises.leetcode.arrays.hard;

@SuppressWarnings("unused")
public class BurstBaloonsDnCMemorization {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) {
            if (x > 0) {
                nums[n++] = x;
            }
        }
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int maxValue = 0;
        for (int k = i + 1; k < j; ++k) {
            maxValue = Math.max(nums[i] * nums[k] * nums[j] + burst(memo, nums, i, k) + burst(memo, nums, k, j), maxValue);
        }
        memo[i][j] = maxValue;
        return maxValue;
    }
}
