package Graph;

import java.util.Arrays;
import java.util.List;

import Graph.BFS.BFS;
import Graph.DFS.DFS;
import Graph.Graphs.DirectedGraph;
import Graph.TopologicalSort.TopologicalSort;
import Graph.Util.GraphUtil;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphUtil.generateUndirectedGraph();
        DirectedGraph<Integer> dag = GraphUtil.generateDAG();

        //graph.displayGraph();
        //BFS.displayBFS(graph);
        //DFS.displayDFSRecursive(graph);
        //DFS.displayDFS(graph);
        List<Integer> dfs = TopologicalSort.dfs(dag);
        List<Integer> kahns = TopologicalSort.kahns(dag);

        System.out.println(kahns);
    }
}
