package com.exercises.leetcode.arrays.medium;

import java.util.HashMap;

@SuppressWarnings("unused")
public class TwoSumClosest {
    public int[] twoSumClosest(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else if (Math.abs(map.get(nums[i]) - i) < dist){
                dist = Math.abs(map.get(nums[i]) - i);
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
        }

        return result;
    }
}
