package com.exercises.leetcode.linkedlist.hard;

import java.util.*;
/*
Question: Find the smallest range that includes at least one number from each of the k lists.

Example:
List 1: [4, 10, 15, 24, 26]
List 2: [0, 9, 12, 20]
List 3: [5, 18, 22, 30]

The smallest range here would be [20, 24] as it contains:
    24 from list 1,
    20 from list 2,
    22 from list 3.
 */
@SuppressWarnings("unused")
public class SmallestRangeKListsIncludesAtLeastOneNumber {

    private class Result {
        public final int startRange, endRange;

        public Result(int startRange, int endRange) {
            this.startRange = startRange;
            this.endRange = endRange;
        }
    }

    private class Data implements Comparable {
        public final int data;
        public final int listNo;

        public Data(int data, int listNo) {
            this.data = data;
            this.listNo = listNo;
        }

        @Override
        public int compareTo(Object o) {
            return data - ((Data)o).data;
        }
    }

    public static void main(String[] args) {
        List<List> lists = new ArrayList<>();
        List list1 = new ArrayList();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);
        List list2 = new ArrayList();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);
        List list3 = new ArrayList();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        Result result = new SmallestRangeKListsIncludesAtLeastOneNumber().findCoveringRange(lists);
        System.out.println(result.startRange + ", " + result.endRange);
    }

    public Result findCoveringRange(List<List> lists) {
        Result result;
        int start = -1;
        int end = -1;
        int rangeDifference = Integer.MAX_VALUE;
        int numberOfLists = lists.size();

        PriorityQueue priorityQueue = new PriorityQueue();
        SortedSet entries = new TreeSet();
        Map<Integer, Data> listNoAndEntry = new HashMap<>();

        for (int i = 0; i < numberOfLists; i++) {
            priorityQueue.add(new Data((int) lists.get(i).remove(0), i));
        }

        while (!priorityQueue.isEmpty()) {
            Data minData = (Data) priorityQueue.remove();
            if (lists.get(minData.listNo).size() > 0) {
                priorityQueue.add(new Data((int) lists.get(minData.listNo).remove(0), minData.listNo));
            }
            if (listNoAndEntry.size() == numberOfLists) {
                Data first = (Data) entries.first();
                int difference = ((Data)entries.last()).data - first.data;
                if (difference + 1 < rangeDifference) {
                    start = first.data;
                    end = ((Data)entries.last()).data;
                }
                entries.remove(first);
                listNoAndEntry.remove(first.listNo);
            }
            if (listNoAndEntry.containsKey(minData.listNo)) {
                entries.remove(listNoAndEntry.remove(minData.listNo));
            }

            listNoAndEntry.put(minData.listNo, minData);
            entries.add(minData);
        }

        if (listNoAndEntry.size() == numberOfLists) {
            Data first = (Data)entries.first();
            int difference = ((Data)entries.last()).data - first.data;

            if (difference + 1 < rangeDifference) {
                start = first.data;
                end = ((Data)entries.last()).data;
            }
            entries.remove(first);
            listNoAndEntry.remove(first.listNo);
        }

        result = new Result(start, end);
        return result;
    }
}

