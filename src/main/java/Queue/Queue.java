package Queue;

public class Queue<T> {
    private static final int MAX_CAPACITY = 100;

    private final int capacity;
    private int head = 0;
    private int tail = -1;
    private int size = 0;
    private final T[] queue;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public Queue() {
        this.capacity = MAX_CAPACITY;
        queue = (T[]) new Object[MAX_CAPACITY];
    }

    public void enqueue(T t) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is full");
        }

        if (tail == capacity - 1) { // wrap around
            tail = 0;
        } else {
            tail++;
        }

        queue[tail] = t;
        size++;
    }

    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        T t = queue[head];
        queue[head] = null;

        if (head == capacity - 1) { // wrap around
            head = 0;
        } else {
            head++;
        }

        size--;
        return t;
    }

    public T peak() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return queue[head];
    }

    public boolean isFull() {
        return getSize() == capacity;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return this.size;
    }
}
