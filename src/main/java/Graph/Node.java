package Graph;

import static java.util.Objects.requireNonNull;

public class Node<T> {

    private final T value;

    public Node(T t) {
        requireNonNull(t);
        value = t;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Node)) {
            return false;
        }

        return this.value.equals(((Node<?>) other).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
