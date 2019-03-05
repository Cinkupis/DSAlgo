package com.exercises.leetcode.mathpuzzles.easy;

@SuppressWarnings("unused")
public class MySqrt {
    public int mySqrt(int x) {
        int root = 0;
        for (long i = 1; i <= x; i++) {
            if (i * i <= x) {
                root = (int)i;
            } else {
                return root;
            }
        }
        return root;
    }
}
