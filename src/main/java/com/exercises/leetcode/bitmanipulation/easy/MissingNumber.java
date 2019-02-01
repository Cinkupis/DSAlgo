package com.exercises.leetcode.bitmanipulation.easy;

@SuppressWarnings("unused")
public class MissingNumber {
    public int missingNumberXOR(int[] nums) {
        // Start with result as length;
        // XOR result with indexes (0 - length - 1)
        // XOR with found number in array
        // Duplicates will XOR each other out (only the odd, non duplicate will be left;
        int result = nums.length;
        for(int index = 0; index < nums.length; index++){
            result ^= index;
            result ^= nums[index];
        }
        return result;
    }

    public int missingNumberSUM(int[] nums) {
        // Sum of all numbers from 0 .. N (0 + 1 + 2 + .. + N)
        // is (N * (N + 1)) / 2.
        // Use this to subtract each number to get the leftover;
        int length = nums.length;
        int sumOfAllNumbersUpToLength = length * (length + 1) / 2;
        for(int i = 0; i < length; i++)
            sumOfAllNumbersUpToLength -= nums[i];
        return sumOfAllNumbersUpToLength;
    }
}
