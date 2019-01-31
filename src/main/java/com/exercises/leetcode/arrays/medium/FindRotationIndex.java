package com.exercises.leetcode.arrays.medium;

@SuppressWarnings("unused")
public class FindRotationIndex {
    public int findRotationIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else if (nums[pivot] < nums[left]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return 0;
    }
}
