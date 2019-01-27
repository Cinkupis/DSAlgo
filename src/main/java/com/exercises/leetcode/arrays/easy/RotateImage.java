package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class RotateImage {
    public void rotate(int[][] matrix) {
        int leftBound = 0;
        int rightBound = matrix.length;

        while (leftBound < rightBound) {
            for (int i = leftBound; i < rightBound - 1; i++) {
                int topLeft = matrix[leftBound][i];
                int topRight = matrix[i][rightBound - 1];
                int botRight = matrix[rightBound - 1][rightBound - 1 - i + leftBound];
                int botLeft = matrix[rightBound - 1 - i + leftBound][leftBound];

                matrix[leftBound][i] = botLeft;
                matrix[i][rightBound - 1] = topLeft;
                matrix[rightBound - 1][rightBound - 1 - i + leftBound] = topRight;
                matrix[rightBound - 1 - i + leftBound][leftBound] = botRight;
            }
            leftBound++;
            rightBound--;
        }
    }
}
