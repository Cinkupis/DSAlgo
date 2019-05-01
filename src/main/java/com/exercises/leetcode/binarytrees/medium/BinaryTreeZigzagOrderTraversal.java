package com.exercises.leetcode.binarytrees.medium;

import com.exercises.leetcode.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class BinaryTreeZigzagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currlvl = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int nexts = 0;
        int currs = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (level % 2 == 0) {
                currlvl.addFirst(curr.val);
            } else {
                currlvl.addLast(curr.val);
            }
            currs--;
            if (curr.left != null) {
                queue.offer(curr.left);
                nexts++;
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                nexts++;
            }

            if (currs == 0) {
                result.add(currlvl);
                currlvl = new LinkedList<>();
                level++;
                currs = nexts;
                nexts = 0;
            }
        }

        return result;
    }
}
