package com.exercises.leetcode.arrays.hard;

import java.util.Stack;

public class CanRepresentPreOrderTraversalBST {

    boolean canRepresentBST(int[] preOrderArray) {
        // Create an empty stack
        Stack<Integer> stack = new Stack();
        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;
        // Traverse given array
        for (int i = 0; i < preOrderArray.length; i++) {
        // If we find a node who is on right side
        // and smaller than root, return false
            if (preOrderArray[i] < root) {
                return false;
            }
            // If preOrderArray[i] is in right subtree of stack top,
            // Keep removing items smaller than preOrderArray[i]
            // and make the last removed item as new
            // root.
            while (!stack.empty() && stack.peek() < preOrderArray[i]) {
                root = stack.peek();
                stack.pop();
            }
            // At this point either stack is empty or
            // preOrderArray[i] is smaller than root, push preOrderArray[i]
            stack.push(preOrderArray[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        CanRepresentPreOrderTraversalBST bst = new CanRepresentPreOrderTraversalBST();

        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        n = pre2.length;
        if (bst.canRepresentBST(pre2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
