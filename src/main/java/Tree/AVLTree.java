package Tree;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {
    public AVLTree(Node<T> root) {
        super(root);
    }

    public static <S extends Comparable<S>> boolean isBalanced(Node<S> rootNode) {
        if (rootNode == null) {
            return true;
        }

        if (!rootNode.isBalanced()) {
            return false;
        }

        return isBalanced(rootNode.left) && isBalanced(rootNode.right);
    }

    @Override
    public void insert(T value) {
        if (contains(value)) {
            return;
        }
        insert(new Node<T>(value));
    }

    private void insert(Node<T> target) {
        Node<T> current = root;
        Node<T> parent = root;
        // parent is null if and only if root is null
        if (parent == null) {
            root = target;
            updateAllHeight(root);
            return;
        }

        while (current != null) {
            parent = current;
            if (target.isLessThan(current)) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (target.isLessThan(parent)) {
            parent.left = target;
        } else {
            parent.right = target;
        }

        target.parent = parent;
        current = target;

        while (current != null) {
            current.updateHeight();
            if (!current.isBalanced()) {
                balance(current);
            }
            current = current.parent;
        }
    }

    private void balance(Node<T> n) {
        if (n.getHeight(n.left) > n.getHeight(n.right)) {
            // n.left is guaranteed to exist because node n is left heavy
            if (n.getHeight(n.left.left) >= n.getHeight(n.left.right)) {
                rightRotate(n);
            } else {
                leftRotate(n.left);
                rightRotate(n);
            }
        } else {
            // n.right is guaranteed to exist
            if (n.getHeight(n.right.right) >= n.getHeight(n.right.left)) {
                leftRotate(n);
            } else {
                rightRotate(n.right);
                leftRotate(n);
            }
        }
    }

    private void rightRotate(Node<T> n) {
        Node<T> left = n.left;
        left.parent = n.parent;
        if (n.parent != null) {
            if (n == n.parent.left) {
                n.parent.left = left;
            } else {
                n.parent.right = left;
            }
        } else {
            root = left;
        }

        n.parent = left;

        if (left.right != null) {
            left.right.parent = n;
            n.left = left.right;
        } else {
            n.left = null;
        }

        left.right = n;
        n.updateHeight();
        n.parent.updateHeight();
    }

    private void leftRotate(Node<T> n) {
        Node<T> right = n.right;

        right.parent = n.parent;
        if (n.parent != null) {
            if (n == n.parent.right) {
                n.parent.right = right;
            } else {
                n.parent.left = right;
            }
        } else {
            root = right;
        }

        n.parent = right;

        if (right.left != null) {
            right.left.parent = n;
            n.right = right.left;
        } else {
            n.right = null;
        }
        right.left = n;
        n.updateHeight();
        n.parent.updateHeight();
    }

    @Override
    public void remove(T value) {
        Node<T> node = find(value);
        if (node != null) {
            remove(node);
        }
    }

    private void remove(Node<T> target) {
        Node<T> current = target.parent;
        if (target.left == null && target.right == null) {
            replaceNode(target, null);
        } else if (target.right == null) {
            replaceNode(target, target.left);
        } else if (target.left == null) {
            replaceNode(target, target.right);
        } else {
            Node<T> successor = findSuccessor(target);
            current = successor;
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

        }

        while (current != null) {
            current.updateHeight();
            if (!current.isBalanced()) {
                balance(current);
            }
            current = current.parent;
        }
    }
}
