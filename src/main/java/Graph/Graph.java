package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
    HashMap<Node<T>, LinkedList<Node<T>>> adjList = new HashMap<>();

    public void add(T t) {
        Node<T> node = new Node<>(t);
        if (!adjList.containsKey(node)) {
            adjList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(T src, T dest) {
        Node<T> s = new Node<>(src);
        Node<T> d  = new Node<>(dest);

        if (!adjList.containsKey(s)) {
            adjList.put(s, new LinkedList<>());
        }

        if (!adjList.containsKey(d)) {
            adjList.put(d, new LinkedList<>());
        }

        adjList.get(s).addFirst(d);
        adjList.get(d).addFirst(s);
    }

    public void displayGraph() {
        adjList.forEach((key, value) -> {
            System.out.print(key + ": ");
            value.forEach(node -> System.out.print(node + " "));
            System.out.println();
        });
    }

    public List<Node<T>> getNeighbours(T value) {
        return getNeighbours(new Node<T>(value));
    }

    public List<Node<T>> getNeighbours(Node<T> node) {
        if (!adjList.containsKey(node)) {
            return null;
        }
        return new ArrayList<>(adjList.get(node));
    }

    public List<Node<T>> getVertices() {
        return new ArrayList<>(adjList.keySet());
    }
}
