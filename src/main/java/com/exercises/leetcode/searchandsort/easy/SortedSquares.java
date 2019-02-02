package com.exercises.leetcode.searchandsort.easy;

@SuppressWarnings("unused")
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            int left = A[start] * A[start];
            int right = A[end] * A[end];
            if (right > left) {
                result[i] = right;
                end--;
            } else {
                result[i] = left;
                start++;
            }
        }
        return result;
    }
}
