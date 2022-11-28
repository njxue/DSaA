package Tree;

public interface Tree<T extends Comparable<T>> {
    Node<T> find(Node<T> target, Node<T> current);
    void insert(Node<T> target, Node<T> current);
    void remove(Node<T> target, Node<T> current);
    Node<T> findMin(Node<T> root);
    Node<T> findMax(Node<T> root);
}
