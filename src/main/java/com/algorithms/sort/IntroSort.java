package com.algorithms.sort;

/*
    Best Case:
    Average Case:
    Worst Case:
 */

@SuppressWarnings("unused")
public class IntroSort {

    /*
     * ------------------------------------------------------
     * Interface to the outer world, takes an array as
     * parameter, and calculates the max depth allowed.
     * ------------------------------------------------------
     */
    public static void sort(int[] arrayToSort){
        int depth = ((int) Math.log(arrayToSort.length)) * 2;
        sort(arrayToSort, depth, 0, arrayToSort.length - 1);
    }

    /*
     * ------------------------------------------------------
     * Sorting loop, decides whether to use quicksort or
     * heapsort.
     * ------------------------------------------------------
     */
    private static void sort(int[] arrayToSort, int depth, int start, int end){
        int length = arrayToSort.length;
        if(length <= 1) {
            return;
        } else if(depth == 0) {
            heapSort(arrayToSort, start, end);
        } else {
            if(start >= end) {
                return;
            }
            int pivot = arrayToSort[(start + end) / 2];
            int index =  partition(arrayToSort, start, end, pivot);
            sort(arrayToSort, depth - 1, start, index - 1);
            sort(arrayToSort, depth - 1, index, end);
        }
    }

    /*
     * ------------------------------------------------------
     * Heap sort implementation, taken and modified from
     * HeapSort.java
     * ------------------------------------------------------
     */
    private static void heapSort(int[] arrayToSort, int start, int end){
        for (int i = end / 2 - 1; i >= start; i--) {
            heapify(arrayToSort, end, i);
        }
        for (int i = end - 1; i >= start; i--) {
            int temp = arrayToSort[start];
            arrayToSort[start] = arrayToSort[i];
            arrayToSort[i] = temp;
            heapify(arrayToSort, i, start);
        }
    }

    /*
     * ------------------------------------------------------
     * Heapify implementation, taken and modified from
     * HeapSort.java
     * ------------------------------------------------------
     */
    private static void heapify(int[] arrayToSort, int heapSize, int index){
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heapSize && arrayToSort[left] > arrayToSort[largest]) {
            largest = left;
        }

        if (right < heapSize && arrayToSort[right] > arrayToSort[largest]) {
            largest = right;
        }

        if (largest != index) {
            int swap = arrayToSort[index];
            arrayToSort[index] = arrayToSort[largest];
            arrayToSort[largest] = swap;
            heapify(arrayToSort, heapSize, largest);
        }
    }

    /*
     * ------------------------------------------------------
     * Partition for Quick sort implementation, taken and modified from
     * QuickSort.java
     * ------------------------------------------------------
     */
    private static int partition(int[] arrayToSort, int start, int end, int pivot){
        while(start <= end){
            while(arrayToSort[start] < pivot){
                start++;
            }

            while(arrayToSort[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = arrayToSort[start];
                arrayToSort[start] = arrayToSort[end];
                arrayToSort[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

}