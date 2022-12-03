package Tree.IntervalTree;

import Tree.AVLTree.AVLTree;
import Tree.Node;

public class IntervalTree extends AVLTree<Integer> {

    IntervalNode root;

    public IntervalTree(Node<Integer> root) {
        super(root);
    }

    public IntervalNode findInterval(int value) {
        IntervalNode current = root;
        while (current != null && !current.containsValue(value)) {
            if (current.left == null || value > current.left.maxEnd) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }
}

