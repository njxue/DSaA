package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Stack;

import Graph.Graphs.DirectedGraph;
import Graph.Node;

public class TopologicalSort {
    public static <T> List<T> dfs(DirectedGraph<T> graph) {
        List<T> sorted = new ArrayList<>();
        List<Node<T>> nodes = graph.getVertices();
        Stack<Node<T>> stack = new Stack<>();
        HashSet<Node<T>> visited = new HashSet<>();

        for (Node<T> src : nodes) {
            if (!visited.contains(src)) {
                stack.push(src);
                while (!stack.isEmpty()) {
                    Node<T> node = stack.pop();
                    if (!visited.contains(node)) {
                        visited.add(node);
                        sorted.add(node.getValue());
                        List<Node<T>> neighbours = graph.getNeighbours(node);
                        for (Node<T> nb : neighbours) {
                            stack.push(nb);
                        }
                    }
                }
            }
        }
        return sorted;
    }

    public static <T> List<T> dfs(DirectedGraph<T> graph) {
        List<T> sorted = new ArrayList<>();
        List<Node<T>> nodes = graph.getVertices();
        Stack<Node<T>> stack = new Stack<>();
        HashSet<Node<T>> visited = new HashSet<>();

        for (Node<T> src : nodes) {
            if (!visited.contains(src)) {
                stack.push(src);
                while (!stack.isEmpty()) {
                    Node<T> node = stack.pop();
                    if (!visited.contains(node)) {
                        visited.add(node);
                        sorted.add(node.getValue());
                        List<Node<T>> neighbours = graph.getNeighbours(node);
                        for (Node<T> nb : neighbours) {
                            stack.push(nb);
                        }
                    }
                }
            }
        }
        return sorted;
    }
}
