package com.exercises.leetcode.dynamicprogramming.medium;

@SuppressWarnings("unused")
public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sumA = 0;
        for (int stone : stones) {
            sumA += stone;
            for (int i = 1500; i >= stone; --i) {
                dp[i] |= dp[i - stone];
            }
        }
        for (int i = sumA / 2; i > 0; --i) {
            if (dp[i]) {
                return sumA - i - i;
            }
        }
        return 0;
    }
}
