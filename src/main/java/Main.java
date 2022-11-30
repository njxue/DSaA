import Tree.BinaryTree;
import Tree.Node;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = BinaryTree.getEmptyTree();
        bt.insert(7);
        bt.insert(4);
        bt.insert(11);
        bt.insert(2);
        bt.insert(6);
        bt.insert(9);
        bt.insert(13);
        bt.insert(1);
        bt.insert(3);
        bt.insert(5);
        bt.insert(8);
        bt.insert(10);
        bt.insert(12);
        bt.insert(14);

        //System.out.println(bt.getRoot().value);
        bt.remove(bt.getRoot().value);
        System.out.println(bt.getRoot().getHeight());
    }
}
