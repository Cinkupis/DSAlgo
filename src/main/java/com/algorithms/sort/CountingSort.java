package com.algorithms.sort;

import java.util.Arrays;

/*
    Best Case:
    Average Case:
    Worst Case:
 */

@SuppressWarnings("unused")
public class CountingSort {
    public static int[] sort(int[] array) {

        int[] sorted = new int[array.length];

        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int[] arrayOfOccurrences = new int[maxValue - minValue + 1];

        for (int i = 0;  i < array.length; i++) {
            int index = array[i] - minValue;
            arrayOfOccurrences[index]++;
        }

        arrayOfOccurrences[0]--;
        for (int i = 1; i < arrayOfOccurrences.length; i++) {
            arrayOfOccurrences[i] = arrayOfOccurrences[i] + arrayOfOccurrences[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int index = array[i] - minValue;
            sorted[arrayOfOccurrences[index]] = array[i];
            arrayOfOccurrences[index]--;
        }

        return sorted;
    }
}
