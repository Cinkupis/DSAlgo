package com.exercises.leetcode.design.easy;

import java.util.Random;

@SuppressWarnings("unused")
public class ShuffleArray {
    private int[] array;
    private Random randomizer;

    public ShuffleArray(int[] nums) {
        randomizer = new Random();
        this.array = nums;
    }

    public int[] reset() {
        return array;
    }

    public int[] shuffle() {
        if (this.array == null) {
            return null;
        }
        int[] shuffled = this.array.clone();
        for(int j = 1; j < shuffled.length; j++) {
            int i = randomizer.nextInt(j + 1);
            swap(shuffled, i, j);
        }
        return shuffled;
    }

    private void swap(int[] shuffled, int i, int j) {
        int t = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = t;
    }
}
