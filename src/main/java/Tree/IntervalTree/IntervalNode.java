package Tree.IntervalTree;


public class IntervalNode {

    IntervalNode left;
    IntervalNode right;
    IntervalNode parent;

    int height = 0;
    int maxEnd;

    int min;
    int max;

    public IntervalNode(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int getHeight() {
        return height;
    }

    public int getHeight(IntervalNode node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }


    public void updateHeight() {
        this.height = Math.max(getHeight(left), getHeight(right)) + 1;
    }


    public void updateMaxEnd() {
        maxEnd = Math.max((Integer) max, Math.max(left.maxEnd, right.maxEnd));
    }

    public boolean isBalanced() {
        return Math.abs(getHeight(left) - getHeight(right)) <= 1;
    }

    public boolean containsValue(int value) {
        return value >= min && value <= max;
    }

    public boolean isLessThan(IntervalNode other) {
        return min <= other.min;
    }

    @Override
    public String toString() {
        return String.format("[Min|Max: %s|%s Left: %s Right: %s]", min, max, left, right);
    }
}
