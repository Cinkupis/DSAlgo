package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class SumRootToLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            rootToLeaf(root, 0);
        }
        return sum;
    }

    private void rootToLeaf(TreeNode node, int currSum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            this.sum += currSum + node.val;
        } else {
            currSum += node.val;
            rootToLeaf(node.left, currSum * 10);
            rootToLeaf(node.right, currSum * 10);
        }
    }
}
