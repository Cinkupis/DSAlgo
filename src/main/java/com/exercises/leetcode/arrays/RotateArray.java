package com.exercises.leetcode.arrays;

@SuppressWarnings("unused")
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == k) {
            return;
        }
        int rotationsLeft = k;
        while (rotationsLeft > nums.length) {
            rotationsLeft = rotationsLeft - nums.length;
        }

        while (rotationsLeft > 0) {
            int previous = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int current = nums[i];
                nums[i] = previous;
                previous = current;
            }
            nums[0] = previous;
            rotationsLeft--;
        }
    }
}
