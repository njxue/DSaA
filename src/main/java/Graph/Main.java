package Graph;

import java.util.List;

import Graph.BFS.BFS;
import Graph.Graphs.DirectedGraph;
import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;
import Graph.SSSP.BellmanFord;
import Graph.SSSP.Dijkstra;
import Graph.TopologicalSort.DFS;
import Graph.TopologicalSort.Kahns;
import Graph.Util.GraphUtil;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphUtil.generateUndirectedGraph();
        DirectedGraph<Integer> dag = GraphUtil.generateDAG();
        WeightedGraph<Character> wg = GraphUtil.generateWeightedGraph();
        Node<Character> src = wg.getNode('S');
        BellmanFord.displayPath(wg, src);
        Dijkstra.displayPath(wg, src);
    }
}
