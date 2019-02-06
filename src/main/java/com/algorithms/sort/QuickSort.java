package com.algorithms.sort;

/*
    Best Case: O(nLog(n))
    Average Case: O(nLog(n))
    Worst Case: O(n^2)
 */

@SuppressWarnings("unused")
public class QuickSort {

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }
}
