package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class CorrectBinaryTree {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    // This function does inorder traversal
    // to find out the two swapped nodes.
    // It sets three pointers, first, middle
    // and last. If the swapped nodes are
    // adjacent to each other, then first
    // and middle contain the resultant nodes
    // Else, first and last contain the
    // resultant nodes
    private void correctBSTUtil(TreeNode root) {
        if( root != null ) {
            // Recur for the left subtree
            correctBSTUtil( root.left);

            // If this node is smaller than
            // the previous node, it's
            // violating the BST rule.
            if (prev != null && root.val < prev.val) {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            correctBSTUtil( root.right);
        }
    }

    // A function to fix a given BST where
    // two nodes are swapped. This function
    // uses correctBSTUtil() to find out
    // two nodes and swaps the nodes to
    // fix the BST
    public void correctBST(TreeNode root) {
        // Initialize pointers needed
        // for correctBSTUtil()
        first = middle = last = prev = null;

        // Set the poiters to find out
        // two nodes
        correctBSTUtil( root );

        // Fix (or correct) the tree
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
