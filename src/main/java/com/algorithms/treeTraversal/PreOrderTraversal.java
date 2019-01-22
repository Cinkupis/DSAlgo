package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class PreOrderTraversal extends abstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            visit(node);
            traverse(node.left);
            traverse(node.right);
        }
    }
}
