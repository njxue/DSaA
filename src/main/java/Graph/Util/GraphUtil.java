package Graph.Util;

import Graph.Graph;
import Graph.Graphs.DirectedGraph;
import Graph.Graphs.UndirectedGraph;
import Graph.Graphs.WeightedGraph;

public class GraphUtil {
    public static Graph<Integer> generateUndirectedGraph() {
        Graph<Integer> graph = new UndirectedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);

        graph.addEdge(8, 9);

        graph.add(10);
        return graph;
    }

    public static DirectedGraph<Integer> generateDAG() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(7, 2);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);

        graph.addEdge(8, 9);

        graph.add(10);
        return graph;
    }

    public static WeightedGraph<Character> generateWeightedGraph() {
        WeightedGraph<Character> graph = new WeightedGraph<>();
        graph.addEdge('A','B', 1);
        graph.addEdge('A', 'C', 4);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('S', 'A', 3);
        graph.addEdge('S', 'B', 5);
        return graph;
    }
}
