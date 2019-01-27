package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int tempIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                length--;
            } else {
                tempIndex++;
                nums[tempIndex] = nums[i];
            }
        }

        return length;
    }
}
