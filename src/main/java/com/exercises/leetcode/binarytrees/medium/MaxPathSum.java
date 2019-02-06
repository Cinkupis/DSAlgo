package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class MaxPathSum {
    private class Result {
        public int val;
    }

    public int findMaxSum(TreeNode root) {
        Result maxSum = new Result();
        maxSum.val = Integer.MIN_VALUE;
        findMaxUtil(root, maxSum);
        return maxSum.val;
    }

    private int findMaxUtil(TreeNode node, Result currentSum) {
        if (node == null) {
            return 0;
        }
        int leftNode = findMaxUtil(node.left, currentSum);
        int rightNode = findMaxUtil(node.right, currentSum);

        int currentVSLeftOrRightAndCurr = Math.max(Math.max(leftNode, rightNode) + node.val, node.val);

        int previousMaxVSLeftAndRightAndCurrent = Math.max(currentVSLeftOrRightAndCurr, leftNode + rightNode + node.val);
        currentSum.val = Math.max(currentSum.val, previousMaxVSLeftAndRightAndCurrent);

        return currentVSLeftOrRightAndCurr;
    }
}
