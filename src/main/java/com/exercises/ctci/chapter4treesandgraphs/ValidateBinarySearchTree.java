package com.exercises.ctci.chapter4treesandgraphs;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class ValidateBinarySearchTree {
    public boolean validateBST(TreeNode startNode) {
        return isBST(startNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value <= max && node.value > min) {
            boolean validLeft = isBST(node.left, min, node.value);
            if (!validLeft) {
                return false;
            }

            boolean validRight = isBST(node.right, node.value, max);
            if (!validRight) {
                return false;
            }

            return true;
        }
        return false;
    }
}
