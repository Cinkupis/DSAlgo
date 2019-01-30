package com.algorithms.sort;

/*
Best Case:
Average Case:
Worst Case:
 */

@SuppressWarnings("unused")
public class HeapSort {
    public void sort(int[] array) {

        int arrayLength = array.length;
        int middle = arrayLength / 2 - 1;
        // Build heap (rearrange array)
        for (int i = middle; i >= 0; i--) {
            heapify(array, arrayLength, i);
        }

        // One by one extract an element from heap
        for (int i = middle; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node index which is
    // an index in arr[]. heapSize is size of heap
    private void heapify(int[] array, int heapSize, int index) {
        int largest = index; // Initialize largest as root
        int left = 2 * index + 1; // left = 2 * index + 1
        int right = 2 * index + 2; // right = 2 * index + 2

        // If left child is larger than root
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }
}
