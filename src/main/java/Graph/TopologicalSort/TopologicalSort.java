package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
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

    public static <T> List<T> kahns(DirectedGraph<T> graph) {
        // count in-degree
        HashMap<Node<T>, Integer> inDegrees = new HashMap<>();
        for (Node<T> node : graph.getVertices()) {
            if (!inDegrees.containsKey(node)) {
                inDegrees.put(node, 0);
            }
            for (Node<T> nb : graph.getNeighbours(node)) {
                if (!inDegrees.containsKey(nb)) {
                    inDegrees.put(nb, 1);
                } else {
                    inDegrees.put(nb, inDegrees.get(nb) + 1);
                }
            }
        }

        // kahns
        Queue<Node<T>> queue = new LinkedList<>();
        List<T> sorted = new ArrayList<>();
        kahnsEnqueueNodes(graph, queue, inDegrees);
        while (!queue.isEmpty()) {
            kahnsDequeueNodes(inDegrees, queue, sorted);
            kahnsEnqueueNodes(graph, queue, inDegrees);
        }
        return sorted;
    }

    private static <T> void kahnsEnqueueNodes(DirectedGraph<T> graph, Queue<Node<T>> queue,
                                              HashMap<Node<T>, Integer> inDegrees) {
        Set<Node<T>> nodesToUpdate = new HashSet<>();
        for (Node<T> node : inDegrees.keySet()) {
            if (inDegrees.get(node) == 0) {
                queue.add(node);
            }
            nodesToUpdate.addAll(graph.getNeighbours(node));
        }
        kahnsUpdateInDegrees(inDegrees, nodesToUpdate);
    }

    private static <T> void kahnsDequeueNodes(HashMap<Node<T>, Integer> inDegrees, Queue<Node<T>> queue, List<T> sorted) {
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            sorted.add(node.getValue());
            inDegrees.remove(node);
        }
    }


    private static <T> void kahnsUpdateInDegrees(HashMap<Node<T>, Integer> inDegrees, Set<Node<T>> nbs) {
        for (Node<T> nb: nbs) {
            inDegrees.put(nb, inDegrees.get(nb) - 1);
        }
    }
}
