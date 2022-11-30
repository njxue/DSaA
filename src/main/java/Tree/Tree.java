package Tree;

public interface Tree<T extends Comparable<T>> {
    Node<T> find(T value);
    void insert(T value);
    void remove(T value);
    Node<T> findMin();
    Node<T> findMax();
}
