package com.dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class BinaryTree {
    private static class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }

        public boolean hasLeftChild() {
            return this.left != null;
        }

        public boolean hasRightChild() {
            return this.right != null;
        }

        public boolean hasNoChildren() {
            return this.left == null && this.right == null;
        }

        public boolean hasOneChild() {
            return this.hasLeftChild() ^ this.hasRightChild();
        }
    }

    private TreeNode root;

    BinaryTree(int value) {
        this.root = new TreeNode(value);
    }

    BinaryTree() {
        this.root = null;
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.hasNoChildren()) {
                return null;
            }
            if (current.hasOneChild()) {
                if (current.right == null) {
                    return current.left;
                }

                if (current.left == null) {
                    return current.right;
                }
            }
            if (current.hasTwoChildren()) {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private void visit(TreeNode node) {
        System.out.println(node.value);
    }

    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public boolean isBalanced() {
        return false;
    }

    public boolean validateBST() {
        return false;
    }

    public TreeNode getRandomNode() {
        return null;
    }
}
