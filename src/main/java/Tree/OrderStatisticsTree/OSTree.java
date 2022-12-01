package Tree.OrderStatisticsTree;

import Tree.AVLTree.AVLTree;
import Tree.Node;

public class OSTree<T extends Comparable<T>> extends AVLTree<T> {

    WeightedNode<T> root;
    public OSTree(WeightedNode<T> root) {
        super(root);
    }

    @Override
    public void insert(T value) {
        if (contains(value)) {
            return;
        }
        insert(new WeightedNode<T>(value));

    }

    private void insert(WeightedNode<T> target) {
        WeightedNode<T> current = root;
        WeightedNode<T> parent = root;
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
            current.updateWeight();
            if (!current.isBalanced()) {
                balance(current);
            }
            current = current.parent;
        }
    }

    private void remove(WeightedNode<T> target) {
        WeightedNode<T> current = target.parent;
        if (target.left == null && target.right == null) {
            replaceNode(target, null);
        } else if (target.right == null) {
            replaceNode(target, target.left);
        } else if (target.left == null) {
            replaceNode(target, target.right);
        } else {
            WeightedNode<T> successor = (WeightedNode<T>) findSuccessor(target);
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
            current.updateWeight();
            current = current.parent;
        }
    }

    private void balance(WeightedNode<T> n) {
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

    private void rightRotate(WeightedNode<T> n) {
        WeightedNode<T> left = n.left;
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

        n.updateWeight();
        left.updateWeight();
    }

    private void leftRotate(WeightedNode<T> n) {
        WeightedNode<T> right = n.right;

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

        n.updateWeight();
        right.updateWeight();
    }

    // Indexed-1 rank
    public int getRank(WeightedNode<T> n) {
        int rank = 0;
        WeightedNode<T> current = root;
        while(current != null && !current.equals(n)) {
            if (current.isLessThan(n)) {
                rank += current.getWeight(current.left) + 1;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (current == null) {
            return -1;
        }
        rank += current.getWeight(current.left) + 1;
        return rank;
    }

    public WeightedNode<T> getNodeAtRank(int rank) {
        WeightedNode<T> current = root;
        while (true) {
            if (current == null) {
                return current;
            }
            int currentRank = current.getWeight(current.left) + 1;
            if (currentRank == rank) {
                return current;
            }
            if (currentRank < rank) {
                current = current.right;
                rank -= currentRank;
            } else {
                current = current.left;
            }
        }
    }
}
