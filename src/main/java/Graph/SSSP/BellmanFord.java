package Graph.SSSP;

import java.util.HashMap;
import java.util.List;

import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;
import Graph.Graphs.WeightedGraph.Edge;

public class BellmanFord {
    public static <T> void displayPath(WeightedGraph<T> graph, Node<T> src) {
        HashMap<Node<T>, Integer> distances = initializeDistances(graph, src); // distance of each node from src
        List<Node<T>> nodes = graph.getNodes();

        boolean notDone = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (!notDone) {
                break;
            }
            notDone = false;
            for (Node<T> n : nodes) {
                List<Edge<T>> edges = n.getEdges();
                for (Edge<T> e : edges) {
                    notDone = relax(e, distances) || notDone;
                }
            }
        }

        System.out.println(String.format("======= Distances from source node %s =======", src));
        for (Node<T> n : distances.keySet()) {
            System.out.println(String.format("%s: %d", n, distances.get(n)));
        }
    }

    private static <T> boolean relax(Edge<T> edge, HashMap<Node<T>, Integer> distances) {
        Node<T> u = edge.getSrc();
        Node<T> v = edge.getDest();
        boolean relaxed = false;
        // Second condition is required to prevent integer overflow
        if (distances.get(v) > distances.get(u) + edge.getWeight() && distances.get(u) != Integer.MAX_VALUE) {
            distances.put(v, distances.get(u) + edge.getWeight());
            relaxed = true;
        }
        return relaxed;
    }

    private static <T> HashMap<Node<T>, Integer> initializeDistances(WeightedGraph<T> graph, Node<T> src) {
        HashMap<Node<T>, Integer> distances = new HashMap<>();
        for (Node<T> n : graph.getNodes()) {
            distances.put(n, n.equals(src) ? 0 : Integer.MAX_VALUE);
        }
        return distances;
    }
}
