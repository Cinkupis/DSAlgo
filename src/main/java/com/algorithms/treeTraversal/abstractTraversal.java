package com.algorithms.treeTraversal;

import com.datastructures.trees.nodes.TreeNode;

public abstract class abstractTraversal {
    void visit(TreeNode node) {
        System.out.print(node.value);
    }

    abstract void traverse(TreeNode root);
}
