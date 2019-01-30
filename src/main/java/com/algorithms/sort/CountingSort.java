package com.algorithms.sort;

import java.util.Arrays;

/*
Best Case:
Average Case:
Worst Case:
 */

@SuppressWarnings("unused")
public class CountingSort {
    private int getMax(int array[]) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > maxValue)
                maxValue = array[i];
        return maxValue;
    }

    private void sort(int inputArray[]) {
        int outputArray[] = new int[inputArray.length];
        int bucket[] = new int[10];
        Arrays.fill(bucket,0);

        for (int i = 0; i < inputArray.length; i++) {
            bucket[inputArray[i]]++;
        }

        for (int i = 1; i < 10; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = inputArray.length - 1; i >= 0; i--) {
            outputArray[bucket[inputArray[i]] - 1] = inputArray[i];
            bucket[inputArray[i]]--;
        }

        for (int i = 0; i < inputArray.length; i++)
            inputArray[i] = outputArray[i];
    }
}
