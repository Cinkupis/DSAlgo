package com.exercises.leetcode.searchandsort.easy;

@SuppressWarnings("unused")
public class MergeTwoSortedArrays {
    public void merge(int[] firstArray, int[] secondArray) {
        int[] mergedArray = new int[firstArray.length + secondArray.length];

        int fArrLastIndex = firstArray.length - 1;
        int sArrLastIndex = secondArray.length - 1;
        for (int mergedArrIndex = mergedArray.length - 1; mergedArrIndex >= 0; mergedArrIndex--) {
            if (fArrLastIndex < 0) {
                mergedArray[mergedArrIndex] = secondArray[sArrLastIndex];
                sArrLastIndex--;
            } else if (sArrLastIndex < 0) {
                mergedArray[mergedArrIndex] = firstArray[fArrLastIndex];
                fArrLastIndex--;
            } else if (secondArray[sArrLastIndex] > firstArray[fArrLastIndex]) {
                mergedArray[mergedArrIndex] = secondArray[sArrLastIndex];
                sArrLastIndex--;
            } else {
                mergedArray[mergedArrIndex] = firstArray[fArrLastIndex];
                fArrLastIndex--;
            }
        }
    }
}