package Deque;

public class Deque<T> {
    private static final int MAX_CAPACITY = 100;

    private final int capacity;
    private int head = -1;
    private int tail = -1;
    private final T[] deque;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Deque(int capacity) {
        this.capacity = capacity;
        deque = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public Deque() {
        this.capacity = MAX_CAPACITY;
        deque = (T[]) new Object[MAX_CAPACITY];
    }

    public void enqueueFront(T t) throws Exception {
        if (isFull()) {
            throw new Exception("Deque is full");
        }

        if (isEmpty()) {
            tail = capacity - 1;
        }

        head = decrement(head);
        deque[head] = t;
        size++;
    }

    public void enqueueBack(T t) throws Exception {
        if (isFull()) {
            throw new Exception("Deque is full");
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = increment(tail);
        deque[tail] = t;
        size++;
    }


    public T dequeueFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        T t = deque[head];
        deque[head] = null;
        head = increment(head);
        size--;
        return t;
    }

    public T dequeueBack() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        T t = deque[tail];
        deque[tail] = null;
        tail = decrement(tail);
        size--;
        return t;
    }

    public T peakFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        return deque[head];
    }

    public T peakBack() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque is empty");
        }
        return deque[tail];
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

    private int decrement(int ptr) {
        if (ptr <= 0) {
            return ptr = capacity - 1;
        }
        return ptr - 1;
    }

    private int increment(int ptr) {
        if (ptr == capacity - 1) {
            return 0;
        }
        return ptr + 1;
    }
}
