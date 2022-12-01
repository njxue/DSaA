package Tree;

import static java.util.Objects.requireNonNull;

public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;
    public int height = 0;

    public Node(T value) {
        this.value = value;
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

    public boolean isBalanced() {
        return Math.abs(getHeight(left) - getHeight(right)) <= 1;
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
        return String.format("[Value|H: %s|%s Left: %s Right: %s]", value, height, left, right);
    }

    public boolean isLessThan(Node<T> otherNode) {
        requireNonNull(otherNode);
        return this.value.compareTo(otherNode.value) <= 0;
    }

}
