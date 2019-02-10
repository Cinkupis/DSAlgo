package com.exercises.leetcode.linkedlist.easy;

import com.exercises.leetcode.binarytrees.TreeNode;
import java.util.Stack;

@SuppressWarnings("unused")
public class FlattenBinaryTreeToLinkedList {
    public  void flatten(TreeNode root) {
        Stack stack = new Stack();
        TreeNode rootNode = root;

        while(rootNode != null || !stack.empty()){
            if (rootNode.right != null) {
                stack.push(rootNode.right);
            }
            if(rootNode.left != null){
                rootNode.right = rootNode.left;
                rootNode.left = null;
            } else if (!stack.empty()) {
                TreeNode temp = (TreeNode) stack.pop();
                rootNode.right=temp;
            }
            rootNode = rootNode.right;
        }
    }
}
