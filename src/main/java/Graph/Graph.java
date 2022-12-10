package Graph;

import java.util.List;

// Undirected Graph
public interface Graph<T> {
    public void add(T t);
    public void addEdge(T src, T dest);
    public void displayGraph();
    public List<Node<T>> getNeighbours(Node<T> node);
    public List<Node<T>> getVertices();
}
