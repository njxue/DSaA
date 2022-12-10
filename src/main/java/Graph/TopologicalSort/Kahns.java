package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import Graph.Graphs.DirectedGraph;
import Graph.Node;

public class Kahns {
    public static <T> List<T> sort(DirectedGraph<T> graph) {
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
        enqueueNodes(graph, queue, inDegrees);
        while (!queue.isEmpty()) {
            dequeueNodes(inDegrees, queue, sorted);
            enqueueNodes(graph, queue, inDegrees);
        }
        return sorted;
    }

    private static <T> void enqueueNodes(DirectedGraph<T> graph, Queue<Node<T>> queue,
                                              HashMap<Node<T>, Integer> inDegrees) {
        Set<Node<T>> nodesToUpdate = new HashSet<>();
        for (Node<T> node : inDegrees.keySet()) {
            if (inDegrees.get(node) == 0) {
                queue.add(node);
            }
            nodesToUpdate.addAll(graph.getNeighbours(node));
        }
        updateInDegrees(inDegrees, nodesToUpdate);
    }

    private static <T> void dequeueNodes(HashMap<Node<T>, Integer> inDegrees, Queue<Node<T>> queue, List<T> sorted) {
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            sorted.add(node.getValue());
            inDegrees.remove(node);
        }
    }


    private static <T> void updateInDegrees(HashMap<Node<T>, Integer> inDegrees, Set<Node<T>> nbs) {
        for (Node<T> nb: nbs) {
            inDegrees.put(nb, inDegrees.get(nb) - 1);
        }
    }
}
