package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val < max && node.val > min) {
            if (!isBST(node.left, min, node.val)) {
                return false;
            }

            if (!isBST(node.right, node.val, max)) {
                return false;
            }

            return true;
        }
        return false;
    }
}
