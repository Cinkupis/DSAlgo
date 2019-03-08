package com.exercises.leetcode.binarytrees.medium;

@SuppressWarnings("unused")
public class PopulatingNextRightPointersinEachNode2 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
    }

    public Node connect(Node root) {
        connectNexts(root);
        return root;
    }

    private void connectNexts(Node root) {
        Node tempChild = new Node();
        Node currentChild;

        while (root != null) {
            currentChild = tempChild;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
            tempChild.next = null;
        }
    }
}
