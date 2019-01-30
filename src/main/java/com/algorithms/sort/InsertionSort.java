package com.algorithms.sort;

/*
Best Case: O(n)
Average Case: O(n^2)
Worst Case: O(n^2)
 */

@SuppressWarnings("unused")
public class InsertionSort {
    /*Function to sort array using insertion sort*/
    public void sort(int[] array) {
        int arrayLength = array.length;
        for (int i = 1; i < arrayLength; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of array[0..i - 1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
