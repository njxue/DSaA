import Tree.AVLTree;
import Tree.BinaryTree;
import Tree.Node;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<Integer>(new Node<>(7));
        avl.insert(3);
        avl.insert(10);
        avl.insert(4);
        avl.insert(1);
        avl.remove(10);
        System.out.println(avl.getRoot());
    }
}
