package com.exercises.leetcode.bitmanipulation.easy;

@SuppressWarnings("unused")
public class MissingNumber {
    public int missingNumberXOR(int[] nums) {
        int result = nums.length;
        for(int index = 0; index < nums.length; index++){
            result ^= index;
            result ^= nums[index];
        }
        return result;
    }

    public int missingNumberSUM(int[] nums) {
        int length = nums.length;
        int sumOfAllNumbersUpToLength = length * (length + 1) / 2;

        for(int i = 0; i < length; i++) {
            sumOfAllNumbersUpToLength -= nums[i];
        }

        return sumOfAllNumbersUpToLength;
    }
}
