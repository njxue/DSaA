package Graph.Graphs;


import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Directed
public class WeightedGraph<T> {

    private HashMap<T, Node<T>> nodes = new HashMap<>();
    private HashSet<Edge<T>> edges = new HashSet<>();

    public void addNode(T value) {
        if (nodes.containsKey(value)) {
            return;
        }
        nodes.put(value, new Node<T>(value));
    }

    public void addNode(Node<T> node) {
        if (nodes.containsKey(node.value)) {
            return;
        }
        nodes.put(node.value, node);
    }

    public Node<T> getNode(T value) {
        for (Node<T> n : nodes.values()) {
            if (n.value.equals(value)) {
                return n;
            }
        }
        return null;
    }

    public void addEdge(T src, T dest, int weight) {
        addNode(src);
        addNode(dest);
        Node<T> s = nodes.get(src);
        Node<T> d = nodes.get(dest);
        Edge<T> e = new Edge<>(s, d, weight);
        s.addEdge(e);
        edges.add(e);
    }

    public List<Node<T>> getNodes() {
        return new ArrayList<>(nodes.values());
    }

    public List<Edge<T>> getEdges() {
        return new ArrayList<>(edges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> n : nodes.values()) {
            for (Edge<T> e : n.getEdges()) {
                sb.append(e);
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    public static class Edge<T> {
        private Node<T> src;
        private Node<T> dest;
        private int weight;

        public Edge(Node<T> src, Node<T> dest, int weight) {
            requireNonNull(src);
            requireNonNull(dest);
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public Node<T> getSrc() {
            return src;
        }

        public Node<T> getDest() {
            return dest;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Edge)) {
                return false;
            }

            Edge<?> other = (Edge<?>) o;
            return this.src.equals(other.src) && this.dest.equals(other.dest);
        }

        @Override
        public int hashCode() {
            return src.hashCode() + dest.hashCode() + weight;
        }

        @Override
        public String toString() {
            return String.format("%s ------ %d ------> %s", src, weight, dest);
        }
    }

    public static class Node<T> {
        private final T value;
        private List<Edge<T>> edges = new ArrayList<>();

        public Node(T value) {
            requireNonNull(value);
            this.value = value;
        }

        public void addEdge(Edge<T> edge) {
            requireNonNull(edge);
            edges.add(edge);
        }

        public T getValue() {
            return value;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) {
                return false;
            }
            return this.value.equals(((Node<?>) o).value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
