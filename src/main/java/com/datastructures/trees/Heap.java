package com.datastructures.trees;

import java.lang.reflect.Array;
import java.util.List;

@SuppressWarnings("unused")
public abstract class Heap<T extends Comparable<T>> {

    protected final T[] heap;
    protected final int maxSize;
    protected int size;

    public Heap(Class<T> clazz, int maxSize) {
        this.maxSize = maxSize;
        this.heap = (T[]) Array.newInstance(clazz, this.maxSize);
        this.size = 0;
    }

    public void push(T data) throws Exception {
        if(this.size >= this.maxSize) {
            throw new Exception();
        }
        this.heap[this.size] = data;
        upHeap();
        this.size++;
    }

    public T get() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        return this.heap[0];
    }

    public T pop() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        T extreme = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = null;
        this.size--;
        downHeap();
        return extreme;
    }

    protected void upHeap() {
        int currentIndex = this.size;
        while(currentIndex > 0) {
            int parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : currentIndex / 2;
            if(upHeapComparator(currentIndex, parentIndex)) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    protected void downHeap() {
        int currentIndex = 0;
        for (int left = (2 * currentIndex) + 1; left < size; left = (2 * currentIndex) + 1) {
            int right = left + 1;
            int extreme = right < size ? findExtremeIndex(left, right) : left;

            if (!downHeapComparator(currentIndex, extreme)) {
                return;
            }

            swap(currentIndex, extreme);
            currentIndex = extreme;
        }
    }

    protected abstract boolean upHeapComparator(int childIndex, int parentIndex);

    protected abstract boolean downHeapComparator(int childIndex, int parentIndex);

    protected abstract boolean extremeComparator(int childIndex, int parentIndex);

    protected int findExtremeIndex(int childIndex, int parentIndex) throws IndexOutOfBoundsException {
        if(childIndex >= this.size || parentIndex >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (extremeComparator(childIndex, parentIndex)) ? childIndex : parentIndex;
    }

    protected void swap(int childIndex, int parentIndex) throws IndexOutOfBoundsException {
        if(childIndex > this.size || parentIndex > this.size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = this.heap[childIndex];
        this.heap[childIndex] = this.heap[parentIndex];
        this.heap[parentIndex] = temp;
    }

    protected int compare(T x, T y) {
        return x.compareTo(y);
    }

    public List<T> getHeap() {
        return List.of(this.heap);
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}