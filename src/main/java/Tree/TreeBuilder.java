package Tree;

import java.util.List;

import Tree.AVLTree.AVLTree;

public class TreeBuilder {

    /**
     * Returns an AVL Tree containing elements in {@code elements}. {@code elements} must be sorted.
     */
    public static <T extends Comparable<T>> AVLTree<T> buildAVL (List<? extends T> elements) {
        if (elements == null || elements.isEmpty()) {
            return new AVLTree<T>(null);
        }
        Node<T> root = buildHelper(elements, 0, elements.size() - 1);
        return new AVLTree<T>(root);
    }


    private static <T extends Comparable<T>> Node<T> buildHelper(List<? extends T> elements, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        T midElem = elements.get(mid);
        Node<T> root = new Node<>(midElem);
        root.left = buildHelper(elements, start, mid - 1);
        root.right = buildHelper(elements, mid + 1, end);
        root.updateHeight();
        return root;
    }
}
