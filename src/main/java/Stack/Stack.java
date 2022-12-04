package Stack;

public class Stack<T> {
    private static final int MAX_CAPACITY = 100;

    private final int capacity;
    private int head = -1;
    private final T[] stack;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        this.capacity = MAX_CAPACITY;
        stack = (T[]) new Object[MAX_CAPACITY];
    }

    public void push(T t) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is full");
        }
        head++;
        stack[head] = t;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        T t = stack[head];
        stack[head] = null;
        head--;
        return t;
    }

    public T peak() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stack[head];
    }

    public boolean isFull() {
        return getSize() == capacity;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return this.head + 1;
    }
}
