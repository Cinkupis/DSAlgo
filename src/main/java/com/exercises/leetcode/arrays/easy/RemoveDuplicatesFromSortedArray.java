package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedArray {
    public static int[] removeDuplicates(int[] input) {
        int trailingIndex = 0;
        int forwardIndex = 1;
        //return if the array length is less than 2
        if (input.length < 2) {
            return input;
        }
        while (forwardIndex < input.length) {
            if (input[forwardIndex] == input[trailingIndex]) {
                forwardIndex++;
            } else {
                trailingIndex++;
                input[trailingIndex] = input[forwardIndex];
                forwardIndex++;
            }
        }
        int[] output = new int[trailingIndex + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = input[k];
        }
        return output;
    }
}
