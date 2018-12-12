package com.dataStructures.trees;

@SuppressWarnings("unused")
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(Class<T> clazz, int maxSize) {
        super(clazz, maxSize);
    }

    @Override
    protected boolean upHeapComparator(int childIndex, int parentIndex) {
        return this.heap[childIndex].compareTo(this.heap[parentIndex]) < 0;
    }

    @Override
    protected boolean downHeapComparator(int childIndex, int parentIndex) {
        return compare(this.heap[childIndex], this.heap[parentIndex]) <= 0;
    }

    @Override
    protected boolean extremeComparator(int childIndex, int parentIndex) {
        return this.heap[childIndex].compareTo(this.heap[parentIndex]) > 0;
    }

}
