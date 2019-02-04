package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class FindCommonNumbersIn3SortedArrays {
    void findCommon(int ar1[], int ar2[], int ar3[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
                k++;
            } else if (ar1[i] < ar2[j]) {
                i++;
            } else if (ar2[j] < ar3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }
}
