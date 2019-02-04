package com.algorithms.sort;

/*
    Best Case: O(n^2)
    Average Case: O(n^2)
    Worst Case: O(n^2)
 */

@SuppressWarnings("unused")
public class SelectionSort {
    public void sort(int[] array) {

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
