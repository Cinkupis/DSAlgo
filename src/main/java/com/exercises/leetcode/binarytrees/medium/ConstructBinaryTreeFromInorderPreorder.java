package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ConstructBinaryTreeFromInorderPreorder {
    Map<Integer, Integer> valueIndexMap = new HashMap<>();
    int preIdx = 0;
    int[] preOrder;
    int[] inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrder = inorder;
        preOrder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return buildSubTree(0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preIdx]);
        int index = valueIndexMap.get(preOrder[preIdx]);
        preIdx++;

        root.left = buildSubTree(left, index - 1);
        root.right = buildSubTree(index + 1, right);

        return root;
    }
}
