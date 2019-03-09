package com.exercises.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return spiral;
        }

        int bottomIdx = matrix.length;
        int rightIdx = matrix[0].length;
        int leftIdx = 0;
        int topIdx = 0;
        boolean[][] checked = new boolean[matrix.length][matrix[0].length];

        while (topIdx < bottomIdx && leftIdx < rightIdx) {
            for (int i = topIdx; i < rightIdx && !checked[leftIdx][i]; i++) {
                spiral.add(matrix[leftIdx][i]);
                checked[leftIdx][i] = true;
            }
            for (int i = leftIdx + 1; i < bottomIdx && !checked[i][rightIdx - 1]; i++) {
                spiral.add(matrix[i][rightIdx - 1]);
                checked[i][rightIdx - 1] = true;
            }
            for (int i = rightIdx - 2; i >= topIdx && !checked[bottomIdx - 1][i]; i--) {
                spiral.add(matrix[bottomIdx - 1][i]);
                checked[bottomIdx - 1][i] = true;
            }
            for (int i = bottomIdx - 2; i > leftIdx && !checked[i][topIdx]; i--) {
                spiral.add(matrix[i][topIdx]);
                checked[i][topIdx] = true;
            }
            leftIdx++;
            topIdx++;
            rightIdx--;
            bottomIdx--;
        }

        return spiral;
    }
}
