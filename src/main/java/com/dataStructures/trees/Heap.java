package com.dataStructures.trees;

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

    /**
     * Inserts an element into the heap.
     * @param data item to insert.
     * @throws Exception
    **/
    public void push(T data) throws Exception {
        if(this.size >= this.maxSize) {
            throw new Exception();
        }
        this.heap[this.size] = data;
        upHeap();
        this.size++;
    }

    /**
     * Returns the current extreme value within the heap.
     * @return object representing current extreme value.
     * @throws Exception
     */
    public T get() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        return this.heap[0];
    }

    /**
     * Returns and removes the current extreme value from within the heap, replacing the old extreme with the next candidate.
     * @return object representing extreme value.
     * @throws Exception
     */
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

    /**
     * 'Bubbles-up' an item from the bottom of the heap (tail of the array) into it's appropriate spot, following the rules of a Min Heap.
     */
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

    /**
     * Percolates-down an item from the top of the heap (head of the array) into it's appropriate spot, following the rules of the underlying heap class.
     */
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

    /**
     * Comparison method used with up-heap operations, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean upHeapComparator(int xIndex, int yIndex);

    /**
     * Comparison method used with down-heap operations, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean downHeapComparator(int xIndex, int yIndex);

    /**
     * Comparison method used when finding an extreme value, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean extremeComparator(int xIndex, int yIndex);

    /**
     * Compares two values within the underlying heap array and returns the index of the maximum.
     * @param xIndex index of first item to use in comparison.
     * @param yIndex index of second item to use in comparison.
     * @return integer representing index of the maximum value from the comparison.
     * @throws IndexOutOfBoundsException
     */
    protected int findExtremeIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size || yIndex >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (extremeComparator(xIndex, yIndex)) ? xIndex : yIndex;
    }

    /**
     * Quick method used to swap two items within the underlying heap array.
     * @param xIndex index of first item to swap.
     * @param yIndex index of second item to swap.
     * @throws IndexOutOfBoundsException
     */
    protected void swap(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex > this.size || yIndex > this.size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = this.heap[xIndex];
        this.heap[xIndex] = this.heap[yIndex];
        this.heap[yIndex] = temp;
    }

    /**
     * Compares two values.
     * @param x first value to use in comparison.
     * @param y second value to use in comparison.
     * @return
     */
    protected int compare(T x, T y) {
        return x.compareTo(y);
    }

    /**
     * Returns the heap in array form.
     * @return array of generic objects representing the heap.
     */
    public List<T> getHeap() {
        return List.of(this.heap);
    }

    /**
     * Returns the allotted maximum size of the underlying heap array.
     * @return an integer representing maximum size of the heap.
     */
    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Returns the current number of elements present within the underlying heap array.
     * @return an integer representing the current number of elements within the heap.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines whether or not the heap contains any elements.
     * @return true if the heap is empty, false if otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

}