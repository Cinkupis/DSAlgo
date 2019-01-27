package com.exercises.leetcode.arrays.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nonDuplicateArray = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            nonDuplicateArray.add(nums[i]);
        }
        return nonDuplicateArray.size() != nums.length;
    }
}
