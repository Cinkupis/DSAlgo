package DataStructures.LinkedLists;

@SuppressWarnings("unused")
public class MySinglyLinkedList<E extends Object> {

    private int size;
    private Node head;

    public MySinglyLinkedList() {
        size = 0;
        this.head = null;
    }

    public MySinglyLinkedList(E value) {
        size = 1;
        this.head = new Node(value);
    }

    public void add(E value) {
        if (this.head == null) {
            this.head = new Node(value);
            size++;
            return;
        }

        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node(value));
        size++;
    }

    public void add(E value, int index) {
        Node temp = new Node(value);
        Node current = this.head;
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
        if (index < 0 || this.head == null || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new ArrayIndexOutOfBoundsException();
            }

            current = current.getNext();
        }
        return current.getValue();
    }

    public E remove(int index) {
        if (index < 0 || index >= size || this.head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size == 1) {
            Node temp = this.head;
            this.head = null;
            return temp.getValue();
        }

        Node current = this.head;
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
            e = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
        } else if (current.getNext() != null) {
            e = current.getValue();
            current.setValue(current.getNext().getValue());
            current.setNext(current.getNext().getNext());
        }

        size--;
        return e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = this.head;
        while (current != null) {
            sb.append(current.getValue());
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

    private class Node extends Object {
        private Node next;
        private E value;

        public Node(E value) {
            this.next = null;
            this.value = value;
        }

        public Node (E value, Node next) {
            this.next = next;
            this.value = value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        private E getValue() {
            return value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }


    }
}
