package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int k = digits.length - 1;
        while (k >= 0) {
            if (digits[k] + 1 == 10) {
                digits[k] = 0;
            } else {
                digits[k]++;
                return digits;
            }
            k--;
            if (k == -1) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int i = 1; i < result.length; i++) {
                    result[i] = 0;
                }
                return result;
            }
        }
        return digits;
    }
}
