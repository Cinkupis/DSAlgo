package com.exercises.leetcode.arrays.hard;

import java.util.Collections;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? (double)maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
