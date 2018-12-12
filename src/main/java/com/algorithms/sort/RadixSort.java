package com.algorithms.sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class RadixSort {
    private int getMax(int array[]) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > maxValue)
                maxValue = array[i];
        return maxValue;
    }

    private void countSort(int inputArray[], int exp) {
        int outputArray[] = new int[inputArray.length];
        int bucket[] = new int[10];
        Arrays.fill(bucket,0);

        for (int i = 0; i < inputArray.length; i++) {
            int digitNumber = (inputArray[i] / exp) % 10;
            bucket[digitNumber]++;
        }

        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = inputArray.length - 1; i >= 0; i--) {
            int digitNumber = (inputArray[i] / exp) % 10;
            outputArray[bucket[digitNumber] - 1] = inputArray[i];
            bucket[digitNumber]--;
        }

        for (int i = 0; i < inputArray.length; i++)
            inputArray[i] = outputArray[i];
    }

    public void sort(int array[]) {
        int maxValue = getMax(array);

        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }
}
