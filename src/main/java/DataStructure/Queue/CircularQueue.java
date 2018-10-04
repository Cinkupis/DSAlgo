package DataStructure.Queue;

public class CircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int[] queue;
    private int tail;
    private int head;
    private int size;
    public CircularQueue(int k) {
        this.queue = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        queue[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return queue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}

class runCircularQueue {
    public static void main(String[] args) {
        int queueSize = 3;
        if (args.length > 0) {
            queueSize = Integer.parseInt(args[0]);
        }
        CircularQueue circularQueue = new CircularQueue(queueSize);
        circularQueue.enQueue(2);
        circularQueue.Rear();
        circularQueue.Front();
        circularQueue.deQueue();
        circularQueue.Front();
        circularQueue.deQueue();
        circularQueue.Front();
        circularQueue.enQueue(4);
        circularQueue.enQueue(2);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
    }
}
