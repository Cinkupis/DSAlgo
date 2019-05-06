package com.exercises.leetcode.arrays.hard;

@SuppressWarnings("unused")
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // If arrays are not equal size, we want nums1 to be smaller;
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        if (n == 0) {
            return 0.0;
        }

        int mIndexMin = 0;
        int mIndexMax = m;
        int mIndex, nIndex;
        while (mIndexMin <= mIndexMax) {
            mIndex = (mIndexMin + mIndexMax) / 2;
            nIndex = (m + n + 1) / 2 - mIndex;
            if (mIndex < m && nums2[nIndex - 1] > nums1[mIndex]) {
                mIndexMin = mIndex + 1;
            } else if (mIndex > 0 && nums1[mIndex - 1] > nums2[nIndex]) {
                mIndexMax = mIndex - 1;
            } else {
                int maxOfLeft, minOfRight;
                if (mIndex == 0) {
                    maxOfLeft = nums2[nIndex - 1];
                } else if (nIndex == 0) {
                    maxOfLeft = nums1[mIndex - 1];
                } else {
                    maxOfLeft = Math.max(nums1[mIndex - 1], nums2[nIndex - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                if (mIndex == m) {
                    minOfRight = nums2[nIndex];
                } else if (nIndex == n) {
                    minOfRight = nums1[mIndex];
                } else {
                    minOfRight = Math.min(nums1[mIndex], nums2[nIndex]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }
}
