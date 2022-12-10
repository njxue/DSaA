package Graph;

import java.util.List;

import Graph.Graphs.DirectedGraph;
import Graph.TopologicalSort.DFS;
import Graph.TopologicalSort.Kahns;
import Graph.Util.GraphUtil;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphUtil.generateUndirectedGraph();
        DirectedGraph<Integer> dag = GraphUtil.generateDAG();

        //graph.displayGraph();
        //BFS.displayBFS(graph);
        //DFS.displayDFSRecursive(graph);
        //DFS.displayDFS(graph);
        List<Integer> dfs = DFS.sort(dag);
        List<Integer> kahns = Kahns.sort(dag);

        System.out.println(kahns);
    }
}
