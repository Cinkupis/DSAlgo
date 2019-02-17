package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

@SuppressWarnings("unused")
public class CorrectBinaryTree {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    private void correctBSTUtil(TreeNode root) {
        if( root != null ) {
            correctBSTUtil( root.left);

            if (prev != null && root.val < prev.val) {
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

    public void correctBST(TreeNode root) {
        first = middle = last = prev = null;
        correctBSTUtil( root );

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
