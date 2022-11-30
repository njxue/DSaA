package Tree;

public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;
    public int height = 0;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Node(T value, Node<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public int getHeight(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    public void updateHeight() {
        this.height = Math.max(getHeight(left), getHeight(right)) + 1;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Node)) {
            return false;
        }
        Node<T> otherNode = (Node<T>) other;
        return otherNode.value == this.value;
    }

    @Override
    public String toString() {
        return String.format("[Value: %s Left: %s Right: %s]", value, left, right);
    }
}
