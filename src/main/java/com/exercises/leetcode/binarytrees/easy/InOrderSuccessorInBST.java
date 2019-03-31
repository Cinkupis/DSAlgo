package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class InOrderSuccessorInBST {
    private TreeNode inOrder;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            findSuccessor(p.right, p);
        } else {
            findSuccessor(root, p);
        }
        return inOrder;
    }

    private void findSuccessor(TreeNode node, TreeNode p) {
        if (node == null || (node.val < p.val && node.right == null)) {
            return;
        }

        if (node.val < p.val) {
            findSuccessor(node.right, p);
        } else if (node.val > p.val) {
            inOrder = node;
            findSuccessor(node.left, p);
        }
    }
}
