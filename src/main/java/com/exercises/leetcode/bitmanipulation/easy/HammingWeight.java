package com.exercises.leetcode.bitmanipulation.easy;

@SuppressWarnings("unused")
public class HammingWeight {
    public int hammingWeight(int n) {
        int number = n;
        int binaryNonZeroDigits = 0;
        while (number != 0) {
            if ((number & 0b001) == 1) {
                binaryNonZeroDigits++;
            }
            number = (number >>> 1);
        }
        return binaryNonZeroDigits;
    }
}
