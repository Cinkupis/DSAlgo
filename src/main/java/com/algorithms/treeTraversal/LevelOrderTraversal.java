package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class LevelOrderTraversal extends abstractTraversal {
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            visit(node);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
