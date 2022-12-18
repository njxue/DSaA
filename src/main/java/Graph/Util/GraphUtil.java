package Graph.Util;

import java.util.HashMap;
import java.util.Stack;

import Graph.Graph;
import Graph.Graphs.DirectedGraph;
import Graph.Graphs.UndirectedGraph;
import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;


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
        graph.addEdge('S', 'A', 5);
        graph.addEdge('S', 'G', 8);
        graph.addEdge('S', 'D', 9);
        graph.addEdge('A', 'C', 15);
        graph.addEdge('A', 'B', 12);
        graph.addEdge('A', 'G', 4);
        graph.addEdge('B', 'C', 3);
        graph.addEdge('B', 'F', 11);
        graph.addEdge('C', 'F', 9);
        graph.addEdge('D', 'G', 5);
        graph.addEdge('D', 'E', 4);
        graph.addEdge('D', 'F', 20);
        graph.addEdge('E', 'B', 1);
        graph.addEdge('E', 'F', 13);
        graph.addEdge('G', 'B', 7);
        graph.addEdge('G', 'E', 6);
        return graph;
    }


    public static <T> HashMap<Node<T>, Integer> initializeDistances(WeightedGraph<T> graph, Node<T> src) {
        HashMap<Node<T>, Integer> distances = new HashMap<>();
        for (Node<T> n : graph.getNodes()) {
            distances.put(n, n.equals(src) ? 0 : Integer.MAX_VALUE);
        }
        return distances;
    }

    public static <T> void displayPaths(HashMap<Node<T>, Integer> distances, HashMap<Node<T>, Node<T>> parents,
                                 Node<T> src) {
        System.out.println(String.format("======= Distances from source node %s =======", src));
        for (Node<T> n : distances.keySet()) {
            if (n.equals(src)) {
                continue;
            }
            Stack<Node<T>> path = new Stack<>();
            Node<T> curr = n;
            while (!curr.equals(src)) {
                path.push(curr);
                curr = parents.get(curr);
            }
            path.push(src);
            while (!path.isEmpty()) {
                Node<T> m = path.pop();
                System.out.print(m);
                if (!m.equals(n)) {
                    System.out.print(" ---> ");
                }
            }
            System.out.println(" LENGTH: " + distances.get(n));
        }
    }
}
