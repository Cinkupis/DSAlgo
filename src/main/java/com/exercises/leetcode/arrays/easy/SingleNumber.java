package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            element = element ^ nums[i];
        }
        return element;
    }
}
