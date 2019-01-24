package com.exercises.ctci.chapter4TreesAndGraphs;

import com.dataStructures.trees.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class CheckForSubtree {

    private boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null ^ subRoot == null || !root.equals(subRoot)) {
            return false;
        }

        if (root.left != null || subRoot.left != null) {
            boolean left = isSubTree(root.left, subRoot.left);
            if (!left) {
                return false;
            }
        }

        if (root.right != null || subRoot.right != null) {
            boolean right = isSubTree(root.right, subRoot.right);
            if (!right) {
                return false;
            }
        }

        return true;
    }

    public boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }
        Queue<TreeNode> mainTreeNodes = new LinkedList<>();
        mainTreeNodes.add(root);

        while (!mainTreeNodes.isEmpty()) {
            TreeNode mainNode = mainTreeNodes.remove();

            if (isSubTree(mainNode, subRoot)) {
                return true;
            }

            if (mainNode.left != null) {
                mainTreeNodes.add(mainNode.left);
            }
            if (mainNode.right != null) {
                mainTreeNodes.add(mainNode.right);
            }
        }

        return false;
    }
}
