package Graph.SSSP;

import static Graph.Util.GraphUtil.displayPaths;
import static Graph.Util.GraphUtil.initializeDistances;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;
import Graph.Graphs.WeightedGraph.Edge;

public class BellmanFord {
    public static <T> void displayPath(WeightedGraph<T> graph, Node<T> src) {
        HashMap<Node<T>, Integer> distances = initializeDistances(graph, src); // distance of each node from src
        HashMap<Node<T>, Node<T>> parents = new HashMap<>();
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
                    notDone = relax(e, distances, parents) || notDone;
                }
            }
        }

        displayPaths(distances, parents, src);
    }

    private static <T> boolean relax(Edge<T> edge, HashMap<Node<T>, Integer> distances,
                                     HashMap<Node<T>, Node<T>> parents) {
        Node<T> u = edge.getSrc();
        Node<T> v = edge.getDest();
        boolean relaxed = false;
        // Second condition is required to prevent integer overflow
        if (distances.get(v) > distances.get(u) + edge.getWeight() && distances.get(u) != Integer.MAX_VALUE) {
            distances.put(v, distances.get(u) + edge.getWeight());
            parents.put(v, u);
            relaxed = true;
        }
        return relaxed;
    }
}
