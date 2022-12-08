package Graph.DFS;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import Graph.*;

public class DFS {
    public static <T> void displayDFS(Graph<T> graph) {
        Stack<Node<T>> stack = new Stack<>();
        HashSet<Node<T>> visited = new HashSet<>();
        List<Node<T>> nodes = graph.getVertices();

        for (Node<T> src : nodes) {
            if (!visited.contains(src)) {
                stack.push(src);
                while (!stack.isEmpty()) {
                    Node<T> node = stack.pop();
                    if (!visited.contains(node)) {
                        visited.add(node);
                        System.out.print(node + " > ");
                        List<Node<T>> neighbours = graph.getNeighbours(node);
                        for (Node<T> nb : neighbours) {
                            stack.push(nb);
                        }
                    }
                }
            }
        }
        System.out.println("end");
    }
}
