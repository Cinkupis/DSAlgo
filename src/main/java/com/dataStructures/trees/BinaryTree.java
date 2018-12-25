package com.dataStructures.trees;

import com.dataStructures.trees.types.TreeTypes;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class BinaryTree {

    private TreeNode root;
    private TreeTypes type;
    private int size;

    public BinaryTree(TreeTypes type) {
        this.type = type;
        this.root = null;
        this.size = 0;
    }

    public BinaryTree(int value, TreeTypes type) {
        this(value);
        this.type = type;
    }

    public BinaryTree(int value) {
        this.root = new TreeNode(value);
        this.type = TreeTypes.BINARY_TREE;
        this.size = 1;
    }

    public BinaryTree() {
        this.root = null;
        this.type = TreeTypes.BINARY_TREE;
        this.size = 0;
    }

    private static class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        // Used in other (non binary search) tree implementations
        // Also in algorithms determining specific attributes of a tree
        // The case with algorithms may apply to Binary Search Trees due to complexity.
        private TreeNode parent;

        private TreeNode(int value) {
            this.value = value;
        }

        private boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }

        private boolean hasLeftChild() {
            return this.left != null;
        }

        private boolean hasRightChild() {
            return this.right != null;
        }

        private boolean hasNoChildren() {
            return this.left == null && this.right == null;
        }

        private boolean hasOneChild() {
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

    private TreeNode addRecursiveBST(TreeNode current, int value) {
        if (current == null) {
            size++;
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursiveBST(current.left, value);
            current.left.parent = current;
        } else if (value > current.value) {
            current.right = addRecursiveBST(current.right, value);
            current.right.parent = current;
        } else {
            return current;
        }

        return current;
    }

    private void addInOrderDT(int value) {
        if (root == null) {
            size++;
            root = new TreeNode(value);
        }

        TreeNode lastNode = findNodeOrLast(null);

        if (lastNode != null) {
            TreeNode node = new TreeNode(value);
            if (lastNode.parent != null && lastNode.equals(lastNode.parent.left) && lastNode.parent.right == null) {
                lastNode.parent.right = node;
                node.parent = lastNode.parent;
            } else if (lastNode.parent != null && lastNode.equals(lastNode.parent.right)) {
                while (lastNode.parent != null && lastNode.equals(lastNode.parent.right)) {
                    lastNode = lastNode.parent;
                }

                if (lastNode.parent == null) {
                    while (lastNode.left != null) {
                        lastNode = lastNode.left;
                    }
                    lastNode.left = node;
                    node.parent = lastNode;
                } else {
                    lastNode = lastNode.parent.right;
                    while (lastNode.left != null) {
                        lastNode = lastNode.left;
                    }
                    lastNode.left = node;
                    node.parent = lastNode;
                }
            } else {
                lastNode.left = node;
                node.parent = lastNode;
            }
            size++;
        }
    }

    private boolean containsNodeRecursiveBST(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursiveBST(current.left, value)
                : containsNodeRecursiveBST(current.right, value);
    }

    private boolean containsNodeInOrderDT(TreeNode current) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.remove();
            if (next.equals(current)) {
                return true;
            }

            if (next.left != null) {
                nodes.add(next.left);
            }
            if (next.right != null) {
                nodes.add(next.right);
            }
        }
        return false;
    }

    private int findSmallestValueDT() {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int smallestValue = root.value;

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.remove();
            if (next.value < smallestValue) {
                smallestValue = next.value;
            }

            if (next.left != null) {
                nodes.add(next.left);
            }
            if (next.right != null) {
                nodes.add(next.right);
            }
        }
        return smallestValue;
    }

    private int findSmallestValueBST(TreeNode current) {
        return current.left == null ? current.value : findSmallestValueBST(current.left);
    }

    private TreeNode deleteRecursiveBST(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            size--;
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
                int smallestValue = findSmallestValueBST(current.right);
                current.value = smallestValue;
                current.right = deleteRecursiveBST(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursiveBST(current.left, value);
            return current;
        }
        current.right = deleteRecursiveBST(current.right, value);
        return current;
    }

    private TreeNode findNodeOrLast(Integer value) {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode nodeToFind = null;

        while (!nodes.isEmpty()) {
            nodeToFind = nodes.remove();
            if (value != null && nodeToFind.value == value) {
                return nodeToFind;
            }

            if (nodeToFind.left != null) {
                nodes.add(nodeToFind.left);
            }
            if (nodeToFind.right != null) {
                nodes.add(nodeToFind.right);
            }
        }
        return nodeToFind;
    }

    private TreeNode findNodeOfIndexLevelOrder(int index) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode ofIndex = nodes.remove();
            if (index == 0) {
                return ofIndex;
            }

            if (ofIndex.left != null) {
                nodes.add(ofIndex.left);
            }

            if (ofIndex.right != null) {
                nodes.add(ofIndex.right);
            }
            index--;
        }
        return null;
    }

    private void deleteDT(int value) {
        if (root == null) {
            throw new NoSuchElementException();
        }

        TreeNode deletedNode = findNodeOrLast(value);
        TreeNode replacementNodeLast = findNodeOrLast(null);

        if (deletedNode == null || deletedNode.value != value) {
            throw new NoSuchElementException();
        }

        size--;
        if (deletedNode == root && replacementNodeLast == root) {
            root = null;
            return;
        }

        TreeNode left = deletedNode.left;
        TreeNode right = deletedNode.right;
        TreeNode parent = deletedNode.parent;

        deletedNode.value = replacementNodeLast.value;
        deletedNode.parent = parent;
        deletedNode.left = left;
        deletedNode.right = right;

        if (replacementNodeLast.parent.right == replacementNodeLast) {
            replacementNodeLast.parent.right = null;
        } else {
            replacementNodeLast.parent.left = null;
        }
    }

    private void visit(TreeNode node) {
        System.out.print(" => " + node.value);
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDifference = Math.abs(leftHeight - rightHeight);
        if (heightDifference > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value <= max && node.value > min) {
            boolean validLeft = isBST(node.left, min, node.value);
            if (!validLeft) {
                return false;
            }

            boolean validRight = isBST(node.right, node.value, max);
            if (!validRight) {
                return false;
            }

            return true;
        }
        return false;
    }

    public void setType(TreeTypes type) {
        this.type = type;
    }

    public void add(int value) {
        switch (type) {
            case BINARY_TREE:
                addInOrderDT(value);
                break;
            case BINARY_SEARCH_TREE:
                root = addRecursiveBST(root, value);
                break;
            default:
                addInOrderDT(value);
                break;
        }
    }

    public boolean containsNode(int value) {
        switch (type) {
            case BINARY_TREE:
                return containsNodeInOrderDT(new TreeNode(value));
            case BINARY_SEARCH_TREE:
                return containsNodeRecursiveBST(root, value);
            default:
                return false;
        }
    }

    public int findSmallestValue() {
        switch (type) {
            case BINARY_TREE:
                return findSmallestValueDT();
            case BINARY_SEARCH_TREE:
                return findSmallestValueBST(root);
            default:
                throw new NoSuchElementException();
        }
    }

    public void delete(int value) {
        switch (type) {
            case BINARY_TREE:
                deleteDT(value);
                break;
            case BINARY_SEARCH_TREE:
                root = deleteRecursiveBST(root, value);
                break;
            default:
                deleteDT(value);
                break;
        }
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

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            System.out.print(" => " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public boolean isBalanced() {
        if (type == TreeTypes.BINARY_TREE) {
            return true;
        }
        return checkHeight(this.root) != Integer.MIN_VALUE;
    }

    public boolean validateBST(TreeNode startNode) {
        if (type == TreeTypes.BINARY_SEARCH_TREE) {
            return true;
        }

        return isBST(startNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode getRandomNode() {
        System.out.println(size);
        int randomIndex = ThreadLocalRandom.current().nextInt(0, size);
        return findNodeOfIndexLevelOrder(randomIndex);
    }

    public TreeNode inOrderSuccessor(TreeNode node) {
        /**
         * if (node.hasRightSubtree()) {
         *  TreeNode leftMostChild = getLeftMostChild(node.right);
         *  return leftMostChild;
         * } else {
         *  while (node.equals(node.parent.right)) {
         *      node = node.parent;
         *  }
         *  return node.parent;
         */
        return null;
    }

    public int numOfPathsWithSum(int sum) {
        if (root == null) {
            return -1;
        }
        return -1;
    }

    public void recreateAllPossibleBSTInputs() {

    }

    public void arrayToMinimalTreeBST(int[] input) {

    }

    public LinkedList<LinkedList<TreeNode>> listOfDepths() {
        return null;
    }

    public boolean checkSubTree(TreeNode anotherRoot) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(10, TreeTypes.BINARY_TREE);
        binaryTree.add(4);
        binaryTree.add(12);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(11);
        //binaryTree.add(13);

        System.out.print("Start");
        binaryTree.levelOrderTraversal();
        System.out.println("\n" + binaryTree.isBalanced());
        System.out.println(binaryTree.containsNode(15));
        System.out.println(binaryTree.containsNode(12));
        System.out.println(binaryTree.findSmallestValue());
        System.out.print("Start");
        binaryTree.levelOrderTraversal();
        System.out.println("\n" + binaryTree.validateBST(binaryTree.root));
        System.out.println("\n" + binaryTree.getRandomNode().value);
    }
}
