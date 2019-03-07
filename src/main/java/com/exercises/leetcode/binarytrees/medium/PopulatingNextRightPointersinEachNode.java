package com.exercises.leetcode.binarytrees.medium;

@SuppressWarnings("unused")
public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connect(root.left, root.right);
        connect(root.right);
        return root;
    }

    private void connect(Node root, Node with) {
        if (root == null) {
            return;
        }
        root.next = with;
        connect(root.left, root.right);
        if (with != null) {
            connect(root.right, with.left);
        }
    }
}
