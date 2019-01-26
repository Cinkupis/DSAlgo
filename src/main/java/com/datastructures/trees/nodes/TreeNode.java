package com.datastructures.trees.nodes;

import java.util.Objects;

@SuppressWarnings("unused")
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    // Used solving only specific exercises
    public TreeNode parent;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
