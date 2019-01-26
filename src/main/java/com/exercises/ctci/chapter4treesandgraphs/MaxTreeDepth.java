package com.exercises.ctci.chapter4treesandgraphs;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class MaxTreeDepth {
    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMax(root.left);
        int rightDepth = getMax(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
