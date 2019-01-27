package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null ^ root.right == null) {
            return false;
        }

        return checkSymmetry(root.left, root.right);
    }

    private boolean checkSymmetry(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null ^ node2 == null || node1.val != node2.val) {
            return false;
        }

        if (!checkSymmetry(node1.left, node2.right)) {
            return false;
        }

        if (!checkSymmetry(node1.right, node2.left)) {
            return false;
        }

        return true;
    }
}
