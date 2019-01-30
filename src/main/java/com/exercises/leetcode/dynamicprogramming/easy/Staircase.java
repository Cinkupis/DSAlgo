package com.exercises.leetcode.dynamicprogramming.easy;

@SuppressWarnings("unused")
public class Staircase {
    public int climbStairs(int n) {
        return tripleStep(n, new int[n + 1]);
    }

    private int doubleStep(int n, int[] numberOfWays) {
        if (n < 4) {
            return n;
        }

        if (numberOfWays[n] == 0) {
            numberOfWays[n] = doubleStep(n - 1, numberOfWays) + doubleStep(n - 2, numberOfWays);
        }
        return numberOfWays[n];
    }

    private int tripleStep(int n, int[] numberOfWays) {
        if (n < 3) {
            return n;
        }

        if (numberOfWays[n] == 0) {
            numberOfWays[n] = tripleStep(n - 1, numberOfWays) + tripleStep(n - 2, numberOfWays) + tripleStep(n - 3, numberOfWays);
        }
        return numberOfWays[n];
    }
}
