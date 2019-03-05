package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
