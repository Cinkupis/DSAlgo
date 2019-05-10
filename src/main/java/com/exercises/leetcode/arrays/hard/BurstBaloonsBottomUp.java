package com.exercises.leetcode.arrays.hard;

@SuppressWarnings("unused")
public class BurstBaloonsBottomUp {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] T = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int left = 1;
                    int right = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        right = nums[j + 1];
                    }

                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k - 1];
                    }
                    if (j != k) {
                        after = T[k + 1][j];
                    }

                    T[i][j] = Math.max(left * nums[k] * right + before + after, T[i][j]);
                }
            }
        }

        return T[0][nums.length - 1];
    }
}
