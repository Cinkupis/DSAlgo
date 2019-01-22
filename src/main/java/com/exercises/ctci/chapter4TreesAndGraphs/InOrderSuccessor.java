package com.exercises.ctci.chapter4TreesAndGraphs;

import com.dataStructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class InOrderSuccessor {
    public TreeNode getSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.hasRightChild()) {
            TreeNode leftMostChild = getLeftMostChild(node.right);
            return leftMostChild;
        } else {
            while (node.parent != null && node.equals(node.parent.right)) {
                node = node.parent;
            }
            return node.parent;
        }
    }

    private TreeNode getLeftMostChild(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
