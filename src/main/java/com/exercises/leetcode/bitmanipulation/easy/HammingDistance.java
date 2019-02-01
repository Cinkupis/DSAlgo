package com.exercises.leetcode.bitmanipulation.easy;

@SuppressWarnings("unused")
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        for (int i = 0; i < 32; i++) {
            int lastBit = (xor >> i) & 1;
            distance = distance + lastBit;
        }
        return distance;
    }
}
