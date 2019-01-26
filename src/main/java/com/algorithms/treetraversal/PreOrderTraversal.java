package com.algorithms.treetraversal;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class PreOrderTraversal extends AbstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            visit(node);
            System.out.print(" => ");
            traverse(node.left);
            traverse(node.right);
        }
    }
}
