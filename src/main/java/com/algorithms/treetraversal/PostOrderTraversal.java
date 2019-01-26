package com.algorithms.treetraversal;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class PostOrderTraversal extends AbstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            traverse(node.right);
            visit(node);
            System.out.print(" => ");
        }
    }
}
