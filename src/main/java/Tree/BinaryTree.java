package Tree;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public Node<T> find(Node<T> target, Node<T> current) {
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

    @Override
    public void insert(Node<T> target, Node<T> current) {
        Node<T> n = find(target, current);
        if (n == null) {
            return;
        }
        if (target.value.compareTo(current.value) <= 0) {
            if (current.left == null) {
                current.left = target;
                return;
            }
            insert(target, current.left);
        } else {
            if (current.right == null) {
                current.right = target;
                return;
            }
            insert(target, current.right);
        }
    }

    @Override
    public Node<T> findMax(Node<T> current) {
        if (current == null || current.right == null) {
            return current;
        }
        return findMax(current.right);
    }

    @Override
    public Node<T> findMin(Node<T> current) {
        if (current == null || current.left == null) {
            return current;
        }
        return findMax(current.left);
    }

    @Override
    public void remove(Node<T> target, Node<T> current) {
        if (target.left == null && target.right == null) {
            replaceNode(target, null);
        } else if (target.right == null) {
            replaceNode(target, target.left);
        } else if (target.left == null) {
            replaceNode(target, target.right);
        } else {
            Node<T> successor = findSuccessor(target);
            remove(successor, current);
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
        } else {
            target.parent.left = newChild;
        }

        if (newChild != null) {
            newChild.parent = target.parent;
        }
    }
}
