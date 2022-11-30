package Tree;

import static java.util.Objects.requireNonNull;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public static <S extends Comparable<S>> BinaryTree<S> getEmptyTree() {
        return new BinaryTree<S>(null);
    }

    @Override
    public Node<T> find(T value) {
         return find(new Node<>(value), root);
    }

    private Node<T> find(Node<T> target) {
        return find(target, root);
    }

    private Node<T> find(Node<T> target, Node<T> current) {
        if (current == null) {
            return null;
        }

        if (target.value.equals(current.value)) {
            return current;
        }

        if (target.value.compareTo(current.value) < 0) {
            return find(target, current.left);
        }

        return find(target, current.right);
    }

    public boolean contains(T value) {
        Node<T> node = find(value);
        return node != null;
    }

    @Override
    public void insert(T value) {
        if (contains(value)) {
            return;
        }
        insert(new Node<T>(value));
    }

    private void insert(Node<T> target) {
        if (root == null) {
            root = target;
            return;
        }
        insert(target, root);
    }

    private void insert(Node<T> target, Node<T> current) {
        if (target.value.compareTo(current.value) <= 0) {
            if (current.left == null) {
                current.left = target;
                target.parent = current;
                updateAllHeight(target);
                return;
            }
            insert(target, current.left);
        } else {
            if (current.right == null) {
                current.right = target;
                target.parent = current;
                updateAllHeight(target);
                return;
            }
            insert(target, current.right);
        }
    }

    @Override
    public Node<T> findMax() {
        return findMax(root);
    }


    private Node<T> findMax(Node<T> current) {
        if (current == null || current.right == null) {
            return current;
        }
        return findMax(current.right);
    }

    @Override
    public Node<T> findMin() {
        return findMin(root);
    }

    private Node<T> findMin(Node<T> current) {
        if (current == null || current.left == null) {
            return current;
        }
        return findMin(current.left);
    }


    @Override
    public void remove(T value) {
        Node<T> node = find(value);
        if (node != null) {
            remove(node);
        }
    }

    private void remove(Node<T> target) {
        if (target.left == null && target.right == null) {
            replaceNode(target, null);
        } else if (target.right == null) {
            replaceNode(target, target.left);
        } else if (target.left == null) {
            replaceNode(target, target.right);
        } else {
            Node<T> successor = findSuccessor(target);
            remove(successor);
            successor.parent = target.parent;
            if (target.parent != null) {
                if (target.parent.left == target) {
                    target.parent.left = successor;
                } else {
                    target.parent.right = successor;
                }
            }

            if (target.left != null) {
                successor.left = target.left;
                target.left.parent = successor;
            }

            if (target.right != null) {
                successor.right = target.right;
                target.right.parent = successor;
            }

            // root was deleted
            if (successor.parent == null) {
                root = successor;
            }

            updateAllHeight(successor);
        }
    }

    private Node<T> findSuccessor(Node<T> node) {
        // min in right subtree
        if (node.right != null) {
            return findMin(node.right);
        }

        // find parent
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    private Node<T> findPredecessor(Node<T> node) {
        // max in left subtree
        if (node.left != null) {
            return findMax(node.left);
        }

        // find parent
        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }

        return node.parent;
    }

    private void replaceNode(Node<T> target, Node<T> newChild) {
        if (target.parent.right == target) {
            target.parent.right = newChild;
            updateAllHeight(newChild);
        } else {
            target.parent.left = newChild;
            updateAllHeight(newChild);
        }
        if (newChild != null) {
            newChild.parent = target.parent;
        }
    }

    private void updateAllHeight(Node<T> start) {
        if (start == null) {
            return;
        }
        start.updateHeight();
        updateAllHeight(start.parent);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void displayPreOrder() {
        displayPreOrder(root);
    }

    private void displayPreOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " ");
        displayPreOrder(current.left);
        displayPreOrder(current.right);
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        displayInOrder(current.left);
        System.out.print(current.value + " ");
        displayInOrder(current.right);
    }

    public void displayPostOrder() {
        displayPostOrder(root);
    }

    private void displayPostOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        displayPostOrder(current.left);
        displayPostOrder(current.right);
        System.out.print(current.value + " ");
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BinaryTree)) {
            return false;
        }

        BinaryTree<T> otherTree = (BinaryTree<T>) other;
        return containSameNodes(root, otherTree.root);

    }

    private boolean containSameNodes(Node<T> currentNode, Node<T> otherNode) {
        if (currentNode == null && otherNode == null) {
            return true;
        }

        if (currentNode == null || otherNode == null) {
            return false;
        }

        if (!currentNode.equals(otherNode)) {
            return false;
        }

        boolean isSameLeftSubtree = containSameNodes(currentNode.left, otherNode.left);
        boolean isSameRightSubtree = containSameNodes(currentNode.right, otherNode.right);
        return isSameLeftSubtree && isSameRightSubtree;
    }
}
