package Graph.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Graph.Graph;
import Graph.Node;

// Undirected Graph
public class UndirectedGraph<T> implements Graph<T> {
    HashMap<Node<T>, LinkedList<Node<T>>> adjList = new HashMap<>();

    @Override
    public void add(T t) {
        Node<T> node = new Node<>(t);
        if (!adjList.containsKey(node)) {
            adjList.put(node, new LinkedList<>());
        }
    }

    @Override
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

    @Override
    public void displayGraph() {
        adjList.forEach((key, value) -> {
            System.out.print(key + ": ");
            value.forEach(node -> System.out.print(node + " "));
            System.out.println();
        });
    }

    @Override
    public List<Node<T>> getNeighbours(Node<T> node) {
        if (!adjList.containsKey(node)) {
            return null;
        }
        return new ArrayList<>(adjList.get(node));
    }

    @Override
    public List<Node<T>> getVertices() {
        return new ArrayList<>(adjList.keySet());
    }
}
