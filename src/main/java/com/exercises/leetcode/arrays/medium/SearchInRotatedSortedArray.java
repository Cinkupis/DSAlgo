package com.exercises.leetcode.arrays.medium;

@SuppressWarnings("unused")
public class SearchInRotatedSortedArray {
    public int findRotationIndex(int left, int right, int[] nums) {
        if (nums[left] < nums[right])
            return 0;

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

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotationIndex = findRotationIndex(0, nums.length - 1, nums);

        if (nums[rotationIndex] == target) {
            return rotationIndex;
        }

        int left = 0;
        int right = 0;

        if (rotationIndex == 0) {
            right = nums.length - 1;
        } else if (target < nums[0]) {
            left = rotationIndex;
            right = nums.length - 1;
        } else {
            right = rotationIndex;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }
}
