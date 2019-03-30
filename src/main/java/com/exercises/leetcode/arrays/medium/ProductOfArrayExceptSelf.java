package com.exercises.leetcode.arrays.medium;

@SuppressWarnings("unused")
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;

        int fmax = 1;
        for (int i = 1; i < nums.length; i++) {
            fmax *= nums[i - 1];
            output[i] = fmax;
        }

        int bmax = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= bmax;
            bmax *= nums[i];
        }

        return output;
    }
}
