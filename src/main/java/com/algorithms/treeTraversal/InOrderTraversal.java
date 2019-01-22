package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class InOrderTraversal extends abstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            visit(node);
            traverse(node.right);
        }
    }
}
