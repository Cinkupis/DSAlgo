package com.dataStructures.arrays;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings({"unused", "unchecked"})
public class MyArrayList<E extends Object> {
    private E[] array;
    private int size = 0;
    private final int DEFAULT_SIZE = 2;

    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_SIZE];
    }

    public E get(int index){
        if(index < size && index > -1){
            return this.array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(E obj){
        if(this.array.length - size == 1){
            this.array = Arrays.copyOf(this.array, this.array.length*2);
        }
        this.array[size++] = obj;
    }

    public int size() {
        return size;
    }

    public E remove(int index){
        if(index < size && index > -1){
            E e = this.array[index];
            this.array[index] = null;
            int temp = index;
            while(temp < size){
                this.array[temp] = this.array[temp + 1];
                this.array[temp + 1] = null;
                temp++;
            }
            size--;
            return e;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(this.array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MyArrayList<?>)) {
            return false;
        }

        MyArrayList<?> comparable = (MyArrayList<?>) object;
        if (this.size() != comparable.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (this.get(i) != comparable.get(i)) {
                return false;
            }
        }

        return true;
    }
}
