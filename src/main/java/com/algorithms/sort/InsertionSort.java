package com.algorithms.sort;

/*
    Best Case: O(n)
    Average Case: O(n^2)
    Worst Case: O(n^2)
 */

@SuppressWarnings("unused")
public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentNum = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > currentNum) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = currentNum;
        }
    }
}
