package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class MaxAnyPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root, maxSum);
        return maxSum;
    }

    private int findMaxPath(TreeNode node, int currSum) {
        if (node == null) {
            return 0;
        }

        int leftPath = findMaxPath(node.left, currSum);
        int rightPath = findMaxPath(node.right, currSum);

        int currMax = Math.max(Math.max(leftPath, rightPath) + node.val, node.val);
        int maxSoFar = Math.max(currMax, leftPath + rightPath + node.val);
        maxSum = Math.max(maxSum, maxSoFar);

        return currMax;
    }
}
