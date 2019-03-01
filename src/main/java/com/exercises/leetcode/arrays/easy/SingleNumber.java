package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class SingleNumber {
    public int getElementAppearedOnce(int[] nums) {
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            element = element ^ nums[i];
        }
        return element;
    }

    public int getElementAppearedOnce(int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        if (startIndex == endIndex) {
            return array[startIndex];
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex % 2 == 0) {
            if (array[midIndex] == array[midIndex + 1]) {
                return getElementAppearedOnce(array, midIndex + 2, endIndex);
            } else {
                return getElementAppearedOnce(array, startIndex, midIndex);
            }
        } else {
            if (array[midIndex] == array[midIndex - 1]) {
                return getElementAppearedOnce(array, midIndex + 1, endIndex);
            } else {
                return getElementAppearedOnce(array, startIndex, midIndex);
            }
        }
    }
}
