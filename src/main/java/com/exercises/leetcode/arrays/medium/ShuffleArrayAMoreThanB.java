package com.exercises.leetcode.arrays.medium;

import java.util.Random;
/*
    There are two integer array arrayA and arrayB in the same size and two integer countA and countB.

    If arrayA[i] > arrayB[i],
        then we increase countA by 1.
    If arrayB[i] > arrayA[i],
        then we increase countB by 1.
    We will do nothing otherwise.

    Now you are given arrayA and arrayB, write a function to shuffle arrayA and so you can get
    countA > countB. Assume the input array are always valid, not empty and the input is
    guaranteed to have answer.

    Example:
        arrayA = [12, 24, 8, 32] arrayB = [13, 25, 32, 11]
    After shuffle:
        arrayA = [24, 32, 8, 12] arrayB = [13, 25, 32, 11]
 */

@SuppressWarnings("unused")
public class ShuffleArrayAMoreThanB {
    public void shuffle(int[] arrayA, int[] arrayB) {
        int middle = arrayA.length / 2;
        int leftEvenSizeIndex = middle % 2 == 0 ? middle - 1: middle;
        partitionAscending(arrayA, leftEvenSizeIndex);
        int start = 0;
        int end = arrayB.length - 1;
        while(start < end){
            if(arrayB[start] < arrayA[leftEvenSizeIndex]){
                swap(arrayB, start, end);
                end--;
            }
            start++;
        }
    }
    private void partitionAscending(int[] arrayA, int leftEvenSizeIndex){
        int start = 0;
        int end = arrayA.length - 1;
        Random rnd = new Random();
        while (start < end){
            int pivot = start + rnd.nextInt(end - start + 1);
            pivot = partitionHelp(arrayA, pivot, start, end);

            if (pivot == leftEvenSizeIndex) {
                break;
            }

            if (pivot < leftEvenSizeIndex) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
    }
    private int partitionHelp(int[] array, int pivot, int start, int end){
        swap(array,pivot,end);

        pivot = end--;
        while(start <= end) {
            if(array[start] > array[pivot]) {
                swap(array,start,end);
                end--;
            }
            start++;
        }
        swap(array,pivot,start);
        return start;
    }

    public void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
