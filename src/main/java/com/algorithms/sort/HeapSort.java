package com.algorithms.sort;

/*
    Best Case: O(nLog(n))
    Average Case: O(nLog(n))
    Worst Case: O(nLog(n))
 */

@SuppressWarnings("unused")
public class HeapSort {
    public void sort(int[] array) {

        int middle = array.length / 2 - 1;
        // Build heap (rearrange array)
        for (int i = middle; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = middle; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int heapSize, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
        }
    }
}
