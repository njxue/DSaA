package Tree.OrderStatisticsTree;

import Tree.Node;

public class WeightedNode<T extends Comparable<T>> extends Node<T> {

    public int weight = 1;
    public WeightedNode<T> left;
    public WeightedNode<T> right;
    public WeightedNode<T> parent;

    public WeightedNode(T value) {
        super(value);
    }

    public int getWeight() {
        return weight;
    }

    public int getWeight(WeightedNode<T> node) {
        if (node == null) {
            return 0;
        }

        return node.getWeight();
    }

    public void updateWeight() {
        this.weight = getWeight(left) + getWeight(right) + 1;
    }

}
