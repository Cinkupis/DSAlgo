package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class LevelOrderTraversal extends abstractTraversal {
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodesInQueue = new LinkedList<>();
        nodesInQueue.add(root);

        while (!nodesInQueue.isEmpty()) {
            TreeNode node = nodesInQueue.remove();
            visit(node);

            if (node.left != null) {
                nodesInQueue.add(node.left);
            }
            if (node.right != null) {
                nodesInQueue.add(node.right);
            }
            if (!nodesInQueue.isEmpty()) {
                System.out.print(" => ");
            }
        }
    }
}
