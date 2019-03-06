package com.exercises.leetcode.arrays.easy;

import java.util.*;

@SuppressWarnings("unused")
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxSize = Math.min(nums1.length, nums2.length);
        int[] result = new int[maxSize];
        int size = 0;

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                result[size] = i;
                map.put(i, 0);
                size++;
            }
        }

        return Arrays.copyOf(result, size);
    }
}
