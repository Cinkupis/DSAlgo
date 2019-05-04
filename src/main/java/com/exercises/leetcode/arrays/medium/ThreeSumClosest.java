package com.exercises.leetcode.arrays.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int currSum = nums[i] + nums[low] + nums[high];
                    if (currSum - target == 0) {
                        return currSum;
                    }
                    if (Math.abs(target - currSum) < Math.abs(target - bestSum)) {
                        bestSum = currSum;
                    }
                    if (currSum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return bestSum;
    }
}
