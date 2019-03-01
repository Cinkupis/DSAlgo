package com.exercises.hackerrank.arrays;

@SuppressWarnings("unused")
public class MiniMaxSum {
    public void miniMaxSum(int[] arr) {
        System.out.print(findMiniSum(arr) + " " + findMaxiSum(arr));
    }

    private long findMaxiSum(int[] arr) {
        long maxiSum = 0;
        int[] fourElements = new int[4];
        for (int i = 0; i < fourElements.length; i++) {
            fourElements[i] = arr[i];
        }
        int minIdx = findMinIdx(fourElements);

        for (int i = 4; i < arr.length; i++) {
            if (fourElements[minIdx] < arr[i]) {
                fourElements[minIdx] = arr[i];
                minIdx = findMaxIdx(fourElements);
            }
        }
        for (int i = 0; i < fourElements.length; i++) {
            maxiSum += fourElements[i];
        }
        return maxiSum;
    }

    private long findMiniSum(int[] arr) {
        long miniSum = 0;
        int[] fourElements = new int[4];
        for (int i = 0; i < fourElements.length; i++) {
            fourElements[i] = arr[i];
        }
        int maxIdx = findMaxIdx(fourElements);

        for (int i = 4; i < arr.length; i++) {
            if (fourElements[maxIdx] > arr[i]) {
                fourElements[maxIdx] = arr[i];
                maxIdx = findMinIdx(fourElements);
            }
        }
        for (int i = 0; i < fourElements.length; i++) {
            miniSum += fourElements[i];
        }
        return miniSum;
    }

    private int findMaxIdx(int[] array) {
        int maxIdx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[maxIdx] < array[i]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private int findMinIdx(int[] array) {
        int minIdx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[minIdx] > array[i]) {
                minIdx = i;
            }
        }
        return minIdx;
    }
}
