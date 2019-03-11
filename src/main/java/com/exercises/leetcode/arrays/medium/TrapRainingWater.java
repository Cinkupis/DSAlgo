package com.exercises.leetcode.arrays.medium;

@SuppressWarnings("unused")
public class TrapRainingWater {
    public int trap(int[] height) {
        int water = 0;

        int leftEdge = 0;
        int rightEdge = height.length - 1;

        while (leftEdge < rightEdge && height[leftEdge] <= height[leftEdge + 1]) {
            leftEdge++;
        }

        while (rightEdge > 0 && height[rightEdge - 1] >= height[rightEdge]) {
            rightEdge--;
        }

        while (leftEdge < rightEdge) {
            int leftValue = height[leftEdge];
            int rightValue = height[rightEdge];

            if (leftValue <= rightValue) {
                leftEdge++;
                while (leftEdge < rightEdge && leftValue >= height[leftEdge]) {
                    water += leftValue - height[leftEdge];
                    leftEdge++;
                }
            } else {
                rightEdge--;
                while (rightEdge > 0 && height[rightEdge] <= rightValue) {
                    water += rightValue - height[rightEdge];
                    rightEdge--;
                }
            }
        }
        return water;
    }
}
