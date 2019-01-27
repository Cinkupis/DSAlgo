package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int pointer = nums.length - 1; pointer >= 0; pointer--) {
            if (nums[pointer] == zero) {
                for (int i = pointer; i < nums.length - 1 && nums[i + 1] != 0; i++) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = zero;
                }
            }
        }
    }
}
