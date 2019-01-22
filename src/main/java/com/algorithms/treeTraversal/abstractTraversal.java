package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

public abstract class abstractTraversal {
    void visit(TreeNode node) {
        System.out.print(" => " + node.value);
    }
}
