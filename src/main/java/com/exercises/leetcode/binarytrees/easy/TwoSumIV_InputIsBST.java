package com.exercises.leetcode.binarytrees.easy;

import com.exercises.leetcode.binarytrees.TreeNode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class TwoSumIV_InputIsBST {
    private Set<Integer> set;
    private int target;
    public boolean findTarget(TreeNode root, int k) {
        this.set = new HashSet<>();
        this.target = k;
        return depthFirstSearch(root);
    }

    public boolean depthFirstSearch(TreeNode root){
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return depthFirstSearch(root.left) || depthFirstSearch(root.right);
    }
}
