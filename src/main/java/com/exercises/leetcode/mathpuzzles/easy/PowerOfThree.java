package com.exercises.leetcode.mathpuzzles.easy;

@SuppressWarnings("unused")
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        double power = Math.log(n) / Math.log(3);
        if (Math.abs(Math.ceil(power) - power) < 0.00000000000001) {
            return true;
        } else {
            return false;
        }
    }
}
