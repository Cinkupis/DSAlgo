package com.exercises.leetcode.arrays.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class FindNumbersThatOccurMoreThanPercentageTimes {
    public Set findNumbers(int[] array, double k) {
        Set result = new HashSet<>();
        double size = array.length / k;
        if (size <= 1) {
            return result;
        }
        int step = (int) size / 2;
        step = step < 1 ? 1 : step;
        for (int i = 0; i < array.length - step; i += step) {
            if (array[i] == array[i + step]) {
                int start = binarySearch(i - step, i, array);
                int end = start + (int) size;
                if (end < array.length && array[end] == array[i]) {
                    result.add(array[i]);
                }
            }
        }
        return result;
    }
    private int binarySearch(int start, int end, int[] array) {
        if (start < 0) {
            return 0;
        }
        int target = array[end];
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
