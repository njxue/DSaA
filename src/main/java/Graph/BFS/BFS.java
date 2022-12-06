package Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Graph.*;

public class BFS {
    public static <T> void displayBFS(Graph<T> graph) {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> visited = new HashSet<>();
        List<Node<T>> nodes = graph.getVertices();

        for (Node<T> src : nodes) {
            if (!visited.contains(src)) {
                queue.add(src);
                while (!queue.isEmpty()) {
                    Node<T> node = queue.poll();
                    System.out.print(node + " > ");
                    visited.add(node);
                    List<Node<T>> neighbours = graph.getNeighbours(node);
                    for (Node<T> nb : neighbours) {
                        if (!visited.contains(nb)) {
                            queue.add(nb);
                            visited.add(nb);
                        }
                    }
                }
            }
        }
        System.out.print("end");
    }
}
