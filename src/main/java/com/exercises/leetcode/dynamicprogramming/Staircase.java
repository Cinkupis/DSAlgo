package com.exercises.leetcode.dynamicprogramming;

@SuppressWarnings("unused")
public class Staircase {
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
