package com.exercises.leetcode.arrays.hard;

import java.util.Stack;

@SuppressWarnings("unused")
public class CanRepresentPreOrderTraversalBST {
    boolean canRepresentBST(int[] preOrderArray) {
        Stack<Integer> stack = new Stack();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < preOrderArray.length; i++) {
            if (preOrderArray[i] < root) {
                return false;
            }
            while (!stack.empty() && stack.peek() < preOrderArray[i]) {
                root = stack.peek();
                stack.pop();
            }
            stack.push(preOrderArray[i]);
        }
        return true;
    }
}
