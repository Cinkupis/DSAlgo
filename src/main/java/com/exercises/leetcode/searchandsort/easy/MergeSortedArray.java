package com.exercises.leetcode.searchandsort.easy;

@SuppressWarnings("unused")
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastMIndex = m - 1;
        int lastNIndex = nums2.length - 1;
        for (int lastOverallIndex = n + m - 1; lastOverallIndex >= 0; lastOverallIndex--) {
            if (lastNIndex < 0) {
                break;
            }
            if (lastMIndex < 0 || nums2[lastNIndex] > nums1[lastMIndex]) {
                nums1[lastOverallIndex] = nums2[lastNIndex];
                lastNIndex--;
            } else {
                nums1[lastOverallIndex] = nums1[lastMIndex];
                lastMIndex--;
            }
        }
    }
}
