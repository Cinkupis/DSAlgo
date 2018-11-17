package DataStructures.LinkedLists;

import java.util.Objects;

@SuppressWarnings("unused")
public class MySinglyLinkedList<E extends Object> {

    private int size;
    private Node root;

    public MySinglyLinkedList() {
        size = 0;
        this.root = null;
    }

    public MySinglyLinkedList(E value) {
        size = 1;
        this.root = new Node(value);
    }

    public void add(E value) {
        if (this.root == null) {
            this.root = new Node(value);
            size++;
            return;
        }

        Node current = this.root;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node(value));
        size++;
    }

    public void add(E value, int index) {
        Node temp = new Node(value);
        Node current = this.root;
        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }

        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    public E get(int index) {
        if (index < 0 || this.root == null || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node current = this.root;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new ArrayIndexOutOfBoundsException();
            }

            current = current.getNext();
        }
        return current.getData();
    }

    public E remove(int index) {
        if (index < 0 || index >= size || this.root == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size == 1) {
            Node temp = this.root;
            this.root = null;
            return temp.getData();
        }

        Node current = this.root;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (i != size - 2) {
                current = current.getNext();
            }
        }
        E e = null;
        if (index == size - 1) {
            e = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        } else if (current.getNext() != null) {
            e = current.getData();
            current.setData(current.getNext().getData());
            current.setNext(current.getNext().getNext());
        }

        size--;
        return e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = this.root;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MySinglyLinkedList<?>)) {
            return false;
        }

        MySinglyLinkedList<?> comparable = (MySinglyLinkedList<?>) object;
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

    @Override
    public int hashCode() {
        return 31 * Objects.hash(root) + Objects.hash(size);
    }

    private class Node extends Object {
        Node next;
        E data;

        public Node(E value) {
            this.next = null;
            this.data = value;
        }

        public Node (E value, Node next) {
            this.next = next;
            this.data = value;
        }

        private void setData(E value) {
            this.data = value;
        }

        public E getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }
}
