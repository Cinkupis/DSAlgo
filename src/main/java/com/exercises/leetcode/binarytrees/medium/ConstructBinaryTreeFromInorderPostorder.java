package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ConstructBinaryTreeFromInorderPostorder {
    private Map<Integer, Integer> valueIndexMap = new HashMap<>();
    private int[] inOrder;
    private int[] postOrder;
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;
        return buildSubTree(0, postorder.length - 1);
    }

    private TreeNode buildSubTree(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postIdx]);
        int index = valueIndexMap.get(postOrder[postIdx]);

        postIdx--;
        root.right = buildSubTree(index + 1, right);
        root.left = buildSubTree(left, index - 1);
        return root;
    }
}
