package com.algorithms.treetraversal;

import com.datastructures.trees.nodes.TreeNode;

public abstract class AbstractTraversal {
    public void visit(TreeNode node) {
        System.out.print(node.value);
    }

    abstract public void traverse(TreeNode root);
}
