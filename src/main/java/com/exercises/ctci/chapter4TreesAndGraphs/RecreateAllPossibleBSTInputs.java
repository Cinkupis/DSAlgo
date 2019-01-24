package com.exercises.ctci.chapter4TreesAndGraphs;

import com.dataStructures.trees.nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class RecreateAllPossibleBSTInputs {

    private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> possibleSequence = (LinkedList<Integer>) prefix.clone();
            possibleSequence.addAll(first);
            possibleSequence.addAll(second);
            results.add(possibleSequence);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public ArrayList<LinkedList<Integer>> recreate(TreeNode root) {
        ArrayList<LinkedList<Integer>> possibleInputs = new ArrayList<>();
        if (root == null) {
            possibleInputs.add(new LinkedList<>());
            return possibleInputs;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.value);

        ArrayList<LinkedList<Integer>> leftSequence = recreate(root.left);
        ArrayList<LinkedList<Integer>> rightSequence = recreate(root.right);

        for (LinkedList<Integer> left : leftSequence) {
            for (LinkedList<Integer> right : rightSequence) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                possibleInputs.addAll(weaved);
            }
        }

        return possibleInputs;
    }

    private void print(ArrayList<LinkedList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("{");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
                if (j + 1 != list.get(i).size()) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }
}
