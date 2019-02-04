package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class SingleNumber {
    // O(n)
    public int getElementAppearedOnce(int[] nums) {
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            element = element ^ nums[i];
        }
        return element;
    }

    public int getElementAppearedOnce(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        // The number that appears once is at the end
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (mid % 2 == 0) {
            //EVEN
            if (arr[mid] == arr[mid + 1]) {
                return getElementAppearedOnce(arr, mid + 2, end);
            } else {
                return getElementAppearedOnce(arr, start, mid);
            }
        } else {
            //ODD
            if (arr[mid] == arr[mid - 1]) {
                return getElementAppearedOnce(arr, mid + 1, end);
            } else {
                return getElementAppearedOnce(arr, start, mid);
            }
        }
    }
}
