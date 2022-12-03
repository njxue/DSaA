package Tree.OrderStatisticsTree;

import java.util.List;

import Tree.AVLTree.AVLTree;
import Tree.Node;

public class OSTree<T extends Comparable<T>> extends AVLTree<T> {

    WeightedNode<T> root;
    public OSTree(WeightedNode<T> root) {
        super(root);
    }

    public void updateTree(WeightedNode<T> current) {
        while (current != null) {
            current.updateHeight();
            if (!current.isBalanced()) {
                balance(current);
            }
            current.updateWeight();
            current = current.parent;
        }
    }

    @Override
    public void insert(T value) {
        if (contains(value)) {
            return;
        }
        insert(new WeightedNode<T>(value));
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
