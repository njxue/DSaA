package Graph.SSSP;

import static Graph.Util.GraphUtil.displayPaths;
import static Graph.Util.GraphUtil.initializeDistances;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;
import Graph.Graphs.WeightedGraph.Edge;

public class Dijkstra {
    public static <T> void displayPath(WeightedGraph<T> graph, Node<T> src) {
        HashMap<Node<T>, Integer> distances = initializeDistances(graph, src); // distance of each node from src
        HashMap<Node<T>, Node<T>> parents = new HashMap<>();
        PriorityQueue<Node<T>> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.add(src);

        while (!pq.isEmpty()) {
            Node<T> n = pq.poll();
            for (Edge<T> e : n.getEdges()) {
                relax(e, distances, parents, pq);
            }
        }
        displayPaths(distances, parents, src);
    }

    private static <T> void relax(Edge<T> e, HashMap<Node<T>, Integer> distances, HashMap<Node<T>, Node<T>> parents,
                                  PriorityQueue<Node<T>> pq) {
        Node<T> u = e.getSrc();
        Node<T> v = e.getDest();

        if (distances.get(v) > distances.get(u) + e.getWeight()) {
            if (!pq.contains(v)) {
                pq.add(v);
            }
            parents.put(v, u);
            distances.put(v, distances.get(u) + e.getWeight());
        }
    }
}
