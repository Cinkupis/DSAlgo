package com.algorithms.treetraversal;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class InOrderTraversal extends AbstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            visit(node);
            System.out.print(" => ");
            traverse(node.right);
        }
    }
}
